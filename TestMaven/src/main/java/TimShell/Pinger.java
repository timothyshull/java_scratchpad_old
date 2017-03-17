package TimShell;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.IOException;
import java.net.UnknownHostException;

public class Pinger {

    public static boolean pingHostByInetAddress(String hostname, int timeout) {
        boolean reachable;
        try {
            InetAddress resolved = InetAddress.getByName(hostname);
            reachable = resolved.isReachable(timeout);
        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return reachable;
    }

    public static boolean pingHostBySocket(String hostname, int port, int timeout) {
        try {
            Socket socket = new Socket();
            InetSocketAddress addr = new InetSocketAddress(hostname, port);
            socket.connect(addr, timeout);
            return true;
        } catch (IOException e) {
            return false; // Either timeout or unreachable or failed DNS lookup.
        }
    }
}
