package TimShell;

public class App {
    public static void main(String[] args) {
        if (args == null || args.length != 3) {
            System.out.println("Usage: pinger <hostname> <port> <timeout in milliseconds>");
        }

        System.out.println("Attempting to resolve: " + args[0]);

        Pinger p = new Pinger();
        int timeout = Integer.parseInt(args[2]);

        boolean withInet = p.pingHostByInetAddress(args[0], timeout);
        System.out.println("Ping with inet class: " + withInet);

        int port = Integer.parseInt(args[1]);
        boolean withSocket = p.pingHostBySocket(args[0], port, timeout);
        System.out.println("Ping with socket class: " + withSocket);
    }
}
