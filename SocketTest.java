import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.client.SocketIOException;

import org.json.JSONException;
import org.json.JSONObject;

public class SocketTest {
    private Socket socket;

    public SocketTest() throws Exception {
//        socket = new Socket("http://localhost:8080/");

        try {
            socket = IO.socket("http://localhost:8080");
        } catch (Exception e) {
        }

        socket.connect();

        // Sends a string to the server.
        socket.send("Hello Server");

        // Sends a JSON object to the server.
        socket.send(new JSONObject().put("key", "value").put("key2",
                "another value"));

        // Emits an event to the server.
        socket.emit("file");
    }

    public void onMessage(JSONObject json, Ack ack) {
        try {
            System.out.println("Server said:" + json.toString(2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onMessage(String data, Ack ack) {
        System.out.println("Server said: " + data);
    }

    public void onError(SocketIOException socketIOException) {
        System.out.println("an Error occured");
        socketIOException.printStackTrace();
    }

    public void onDisconnect() {
        System.out.println("Connection terminated.");
    }

    public void onConnect() {
        System.out.println("Connection established");
    }

    public void on(String event, Ack ack, Object... args) {
        System.out.println("Server triggered event '" + event + "'");
    }

    public static void main(String[] args) {
        try {
            new SocketTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}