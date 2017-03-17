package com.sio;

import io.socket.emitter.Emitter;
import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.client.SocketIOException;

import org.json.JSONException;
import org.json.JSONObject;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;

public class SioClient {
    private Socket socket;

    public SioClient() throws Exception {

        try {
            socket = IO.socket("http://localhost:8080");
        } catch (Exception e) {
            System.err.println("Socket.io error: " + e.getMessage());
        }

//        socket.connect();

//        // Sends a string to the server.
//        socket.send("Hello Server");
//
//        // Sends a JSON object to the server.
//        socket.send(new JSONObject().put("key", "value").put("key2",
//                "another value"));
//
//        // Emits an event to the server.
//        socket.emit("file");

        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            InputStream inputStream;



            @Override
            public void call(Object... args) {
                System.out.println("connected");
//                socket.emit("test.event", "test1", "test2", "test3");
//                socket.disconnect();
            }

        }).on("test.event.res", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
//                System.out.println("Received test event");
//                IOUtils.copy(inputStream, System.out);
                System.out.println(args[0]);
            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {}

        });
        socket.connect();
    }

//    public void onMessage(JSONObject json, Ack ack) {
//        try {
//            System.out.println("Server said:" + json.toString(2));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void onMessage(String data, Ack ack) {
//        System.out.println("Server said: " + data);
//    }
//
//    public void onError(SocketIOException socketIOException) {
//        System.out.println("an Error occured");
//        socketIOException.printStackTrace();
//    }
//
//    public void onDisconnect() {
//        System.out.println("Connection terminated.");
//    }
//
//    public void onConnect() {
//        System.out.println("Connection established");
//    }
//
//    public void on(String event, Ack ack, Object... args) {
//        System.out.println("Server triggered event '" + event + "'");
//    }

    public void triggerTestEvent() {
        System.out.println("test event triggered");
        socket.emit("test.event", "test1", "test2", "test3");
    }

    public static void main(String[] args) {
        System.out.println("Socket.io Java client started...");
        try {
            new SioClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}