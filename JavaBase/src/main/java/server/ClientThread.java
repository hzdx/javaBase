package server;

import java.io.*;
import java.net.Socket;
import java.util.Date;


public class ClientThread implements Runnable {

    private float requestDelay = (float) 0.5;//

    private Socket _s;
    private BufferedReader i;
    private PrintStream o;

    public ClientThread(Socket s) {
        this._s = s;
    }

    public void run() {
        try {
            this.i = new BufferedReader(new InputStreamReader(this._s.getInputStream()));
            this.o = new PrintStream(this._s.getOutputStream());

            String request = this.getValidRequest();

            if (!request.equals("")) {
//                System.out.print("当前虚拟机最大可用内存为:");
//                System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
//                System.out.print("当前，虚拟机已占用内存:");
//                System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
                this.o.println("HTTP/1.1 200 OK");
                Date now = new Date();
                this.o.println("Data:" + now);
                this.o.println("Server: JHServer");
                this.o.println("Access-Control-Allow-Origin:*");

                this.o.println("Content-Type: text/html; charset=UTF-8");
                this.o.println();
                String content = "hello,connected server success!";

//                System.out.print("当前虚拟机最大可用内存为:");
//                System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
//                System.out.print("当前，虚拟机已占用内存:");
//                System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");

                this.o.println(content);
                content = "";
                this.o.flush();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this._s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private String getValidRequest() {

        float second = (float) 0.0;
        boolean isGo = true;
        String request = null;
        try {
            while (!this.i.ready()) {
                second += 0.01;
                if (second > this.requestDelay) {
                    System.out.println("One Client Delayed " + this._s);
                    isGo = false;
                    break;
                }
                Thread.sleep(10);
            }

            if (isGo == true) {
                request = this.i.readLine();//GET /hello HTTP/1.1
                if (request.contains("GET /") && request.contains(" HTTP/")) {
                    request = request.substring(request.indexOf("/"), request.indexOf(" HTTP/"));
                    System.out.println("Client Request Info: " + request);
                } else {
                    isGo = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isGo == true) {
                return request;
            } else {
                return "null";
            }
        }
    }

    private void close() {
        try {
            if (this.i != null) {
                this.i.close();
                this.i = null;
            }
            if (this.o != null) {
                this.o.close();
                this.o = null;
            }
            if (this._s != null) {
                this._s.close();
                this._s = null;
            }
            System.out.println("One Client Disconnected...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}