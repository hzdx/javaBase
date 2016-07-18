package io.net.tcp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class LoginClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("192.168.183.1", 10008);
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		for (int x = 0; x < 3; x++) {
			String line = bufr.readLine();
			if (line == null)
				break;
			out.println(line);
			String info = bufIn.readLine();

			System.out.println("info:" + info);
			if (info.contains("over"))
				break;
		}

		bufr.close();
		s.close();
	}
}

class LoginServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10008);
		while (true) {
			Socket s = ss.accept();
			new Thread(new UserThread(s)).start();
		}
	}

}

class UserThread implements Runnable {
	private Socket s;

	UserThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "...is connected");
		try {

			for (int x = 0; x < 3; x++) {
				BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String name = bufIn.readLine();
				if (name == null)
					break;
				BufferedReader bufr = new BufferedReader(new FileReader("user.txt"));
				PrintWriter out = new PrintWriter(s.getOutputStream(), true);
				String line = null;
				boolean flag = false;
				while ((line = bufr.readLine()) != null) {
					if (line.equals(name)) {
						flag = true;
						break;
					}

				}
				if (flag) {
					System.out.println(name + " correct");

					out.println(name + " correct");
					break;
				} else {
					System.out.println(name + " incorrect");
					out.println(name + " incorrect, left " + (2 - x) + " chance");
				}

			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}