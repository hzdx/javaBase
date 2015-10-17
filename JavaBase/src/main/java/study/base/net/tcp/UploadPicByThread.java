package study.base.net.tcp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class PicClient2 {
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.out.println("��ѡ��һ��jpg��ʽ��ͼƬ");
			return;

		}
		File file = new File(args[0]);
		if (!(file.exists() && file.isFile())) {
			System.out.println("���ļ������ڻ��߲����ļ�");
			return;
		}
		if (!(file.getName().endsWith(".jpg"))) {
			System.out.println("�ļ�������jpg��ʽ");
			return;
		}
		if (file.length() > 1024 * 1024 * 5) {
			System.out.println("�ļ����");
			return;
		}

		Socket s = new Socket("192.168.183.1", 10007);
		FileInputStream fis = new FileInputStream(file);
		OutputStream out = s.getOutputStream();

		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = fis.read(buf)) != -1) {
			out.write(buf, 0, len);
		}

		s.shutdownOutput();

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));
		String str = bufIn.readLine();
		System.out.println(str);

		fis.close();
		s.close();
	}
}

class PicThread implements Runnable {
	private Socket s;

	PicThread(Socket s) {
		this.s = s;
	}

	public void run() {
		int count = 1;
		String ip = s.getInetAddress().getHostAddress();
		try {
			System.out.println(ip + "...is connected");
			File file = new File(ip + "(" + (count) + ").jpg");
			while (file.exists())
				file = new File(ip + "(" + (count++) + ").jpg");
			FileOutputStream fos = new FileOutputStream(file);
			InputStream in = s.getInputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = in.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
			OutputStream out = s.getOutputStream();
			out.write("ͼƬ�ϴ��ɹ�".getBytes());
			fos.close();
			s.close();
		} catch (Exception e) {
			throw new RuntimeException("upload fail");
		}
	}
}

class PicServer2 {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10007);

		while (true) {
			Socket s = ss.accept();
			new Thread(new PicThread(s)).start();
		}
		// ss.close();
	}
}
