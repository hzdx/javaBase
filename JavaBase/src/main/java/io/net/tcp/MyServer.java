package io.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer {

	public static class HandleRequestRunnable implements Runnable {
		final Socket socket;

		public HandleRequestRunnable(Socket socket) {
			this.socket = socket;

		}

		@Override
		public void run() {
			try {
				handleRequest(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	final static String response = "HTTP/1.0 200 OK\r\n" + "Content-type: text/plain\r\n" + "\r\n" + "Hello World\r\n";

	public static void handleRequest(Socket socket) throws IOException {

		// Read the input stream, and return "200 OK"
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(in.readLine());

			OutputStream out = socket.getOutputStream();
			out.write(response.getBytes(StandardCharsets.UTF_8));
		} finally {
			socket.close();
		}

	}

	public static void main(String[] args) throws IOException {

		ServerSocket listener = new ServerSocket(8081);// 监听端口
		ExecutorService executor = Executors.newFixedThreadPool(4);// 线程数量固定，缓冲队列不限的线程池
		try {
			while (true) {
				Socket socket = listener.accept();
				try {
					executor.submit(new HandleRequestRunnable(socket)); // 每接收一个请求，开启线程处理请求

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} finally {
			listener.close();
		}
	}
}
