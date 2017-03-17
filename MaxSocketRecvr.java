package examples;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import com.cycling74.max.*;
import com.cycling74.net.*;

@WebSocket(maxTextMessageSize = 64 * 1024)
public class MaxSocketRecvr extends MaxObject {
    private TcpReceiver tr;

    @SuppressWarnings("unused")
    private Session session;

    private final CountDownLatch closeLatch;

    public MaxSocketRecvr(Atom args[]) {
        this.closeLatch = new CountDownLatch(1);
        declareTypedIO("M", "A");
        setOutletAssist(0, "(anything) received messages");
        setInletAssist(0, "(message) control commands");
        declareAttribute("port", "getPort", "setPort");
        tr = new TcpReceiver();
        tr.setDebugString("net.tcp.recv");
        tr.setCallback(this, "receiver");
    }

    private void receiver(Atom[] a) {
        outlet(0, a);
    }

    private void setPort(int p) {
        tr.setPort(p);
    }

    private Atom[] getPort() {
        return new Atom[]{Atom.newAtom(tr.getPort())};
    }

    public void active(boolean b) {
        tr.setActive(b);
    }

    protected void notifyDeleted() {
        tr.close();
    }

    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.printf("Connection closed: %d - %s%n", statusCode, reason);
        this.session = null;
        this.closeLatch.countDown();
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.printf("Got connect: %s%n", session);
        this.session = session;
        try {
            Future<Void> fut;
            fut = session.getRemote().sendStringByFuture("Hello");
            fut.get(2, TimeUnit.SECONDS);
            fut = session.getRemote().sendStringByFuture("Thanks for the conversation.");
            fut.get(2, TimeUnit.SECONDS);
            session.close(StatusCode.NORMAL, "I'm done");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @OnWebSocketMessage
    public void onMessage(String msg) {
        System.out.printf("Got msg: %s%n", msg);
    }
}






