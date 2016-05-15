package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int PORT = 1720;
    public static String charset = "utf-8";
    private ServerSocket ss;
    private Socket client;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try {
            this.ss = new ServerSocket(this.PORT);
            System.out.println("Server Listening Port " + this.PORT + "...");
            boolean isGo = true;
            while (isGo) {
                this.client = this.ss.accept();
                System.out.println("One Client Connected. " + this.client);
                ClientThread ct = new ClientThread(this.client);
                Thread t = new Thread(ct);
                t.start();
                System.out.println("One Client Thread Already Started...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (this.ss != null) {
                    this.ss.close();
                    this.ss = null;
                }
                if (this.client != null) {
                    this.client.close();
                    this.client = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}