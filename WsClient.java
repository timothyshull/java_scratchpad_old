import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;

/** This example demonstrates how to create a websocket connection to a server. Only the most important callbacks are overloaded. */
public class WsClient extends WebSocketClient {

    public WsClient( URI serverUri , Draft draft ) {
        super( serverUri, draft );
    }

    public WsClient( URI serverURI ) {
        super( serverURI );
    }

    @Override
    public void onOpen( ServerHandshake handshakedata ) {
        System.out.println( "opened connection" );
//        this.send("file");
        // if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
    }

    @Override
    public void onMessage( String message ) {
        System.out.println( "received: " + message );
    }

//    @Override
//    public void onFragment( Framedata fragment ) {
//        System.out.println( "received fragment: " + new String( fragment.getPayloadData().array() ) );
//    }

    @Override
    public void onClose( int code, String reason, boolean remote ) {
        // The codecodes are documented in class org.java_websocket.framing.CloseFrame
        System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) );
    }

    @Override
    public void onError( Exception ex ) {
        ex.printStackTrace();
        // if the error is fatal then onClose will be called additionally
    }

    public static void main( String[] args ) throws URISyntaxException {
        WsClient c = new WsClient( new URI( "ws://echo.websocket.org" ));

//        WebSocketImpl.DEBUG = true;
//
//        WebSocketChatClient chatclient = new WebSocketChatClient( new URI( "wss://localhost:8887" ) );

//        // load up the key store
//        String STORETYPE = "JKS";
//        String KEYSTORE = "keystore.jks";
//        String STOREPASSWORD = "storepassword";
//        String KEYPASSWORD = "keypassword";
//
//        KeyStore ks = KeyStore.getInstance( STORETYPE );
//        File kf = new File( KEYSTORE );
//        ks.load( new FileInputStream( kf ), STOREPASSWORD.toCharArray() );
//
//        KeyManagerFactory kmf = KeyManagerFactory.getInstance( "SunX509" );
//        kmf.init( ks, KEYPASSWORD.toCharArray() );
//        TrustManagerFactory tmf = TrustManagerFactory.getInstance( "SunX509" );
//        tmf.init( ks );
//
//        SSLContext sslContext = null;
//        sslContext = SSLContext.getInstance( "TLS" );
//        sslContext.init( kmf.getKeyManagers(), tmf.getTrustManagers(), null );
//        // sslContext.init( null, null, null ); // will use java's default key and trust store which is sufficient unless you deal with self-signed certificates
//
//        SSLSocketFactory factory = sslContext.getSocketFactory();// (SSLSocketFactory) SSLSocketFactory.getDefault();
//
//        chatclient.setSocket( factory.createSocket() );
//
//        chatclient.connectBlocking();
//
//        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
//        while ( true ) {
//            String line = reader.readLine();
//            if( line.equals( "close" ) ) {
//                chatclient.close();
//            } else {
//                chatclient.send( line );
//            }
//        }

        c.connect();
    }

}