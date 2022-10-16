package com.leetcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


/**
 * @author Mostafa
 */
public class ServerTest {
    static List<ServerClientConnection> sockets = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(6666)) {

            System.out.println("<<< Server Started Successfully >>>");
            while (!serverSocket.isClosed()) {
                Socket client = serverSocket.accept();
                ServerClientConnection newClient = new ServerClientConnection(client, ServerTest::sendAll, ServerTest::onClose);
                newClient.start();
                sockets.add(newClient);
            }

        }

    }

    public static void onClose(ServerClientConnection serverClient) {
        sockets.remove(serverClient);
        try {
            serverClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendAll(ServerClientConnection serverClient, String message) {
        for(ServerClientConnection sc : sockets) {
            if(sc != serverClient) {
                try {
                    sc.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        serverClient.close();
                    } catch (IOException ioException) {
                    }
                }
            }
        }
    }


    public static  class ServerClientConnection extends Thread{
        Socket socket;
        BufferedReader reader;
        BufferedWriter writer;
        BiConsumer<ServerClientConnection, String> onMessageReceived;
        Consumer<ServerClientConnection> onCloseHandler;

        public ServerClientConnection(Socket socket, BiConsumer<ServerClientConnection, String> onMessageReceived, Consumer<ServerClientConnection> onCloseHandler) throws IOException {
            this.socket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            this.onMessageReceived = onMessageReceived;
            this.onCloseHandler = onCloseHandler;
        }

        public void sendMessage(String message) throws IOException{
            writer.write(message);
        }

        @Override
        public void run() {

            while (socket.isConnected()) {
                try {
                    String message = reader.readLine();
                    onMessageReceived.accept(this, message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            onCloseHandler.accept(this);

        }


        public void close() throws IOException{
            if(writer != null) {
                writer.close();
            }
            if(reader != null) {
                reader.close();
            }
            if(socket != null) {
                socket.close();
            }

        }
    }
}
