package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

public class MyServer {

    public static void main(String[] args) throws IOException {

        ServerSocket listener = new ServerSocket(8081);//监听端口
        ExecutorService executor = Executors.newFixedThreadPool(4);//线程数量固定，缓冲队列不限的线程池
        ExecutorService executor1 =
                new ThreadPoolExecutor(4, 4,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>(16),
                        new ThreadPoolExecutor.DiscardPolicy());      //固定了线程数和缓存队列大小的线程池，多余的请求采用丢弃（DiscardPolicy）策略

        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    executor.submit(new HandleRequestRunnable(socket));     //每接收一个请求，开启线程处理请求
                    //executor1.submit( new HandleRequestRunnable(socket) );
                    //handleRequest(socket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
            listener.close();
        }
    }


    final static String response =
            "HTTP/1.0 200 OK\r\n" +
                    "Content-type: text/plain\r\n" +
                    "\r\n" +
                    "Hello World\r\n";

    public static void handleRequest(Socket socket) throws IOException {

        // Read the input stream, and return "200 OK"
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());

            OutputStream out = socket.getOutputStream();
            out.write(response.getBytes(StandardCharsets.UTF_8));
        } finally {
            socket.close();
        }

    }


    public static class HandleRequestRunnable implements Runnable {
        final Socket socket;

        public HandleRequestRunnable(Socket socket) {
            this.socket = socket;

        }


        public void run() {
            try {
                handleRequest(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
