package io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 使用PipedInputStream和PipedOutputStream在线程间进行通信
 *
 */
public class PipedStreamDemo {
	public static void main(String[] args) throws IOException {
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);
		Read r = new Read(in);
		Write w = new Write(out);
		new Thread(r).start();
		new Thread(w).start();
	}
}

class Read implements Runnable {
	private PipedInputStream in;

	Read(PipedInputStream in) {
		this.in = in;
	}

	@Override
	public void run() {
		try {
			byte[] buf = new byte[1024];
			System.out.println("reader 开始读!");
			int len = in.read(buf);
			System.out.println("reader 读完了");
			String s = new String(buf, 0, len);
			System.out.println(s);
			in.close();
		} catch (IOException e) {
			throw new RuntimeException("reader RuntimeException");
		}
	}
}

class Write implements Runnable {
	private PipedOutputStream out;

	Write(PipedOutputStream out) {
		this.out = out;
	}

	@Override
	public void run() {
		try {
			System.out.println("Writer run");
			Thread.sleep(6000);
			out.write("piped lai la".getBytes());
			out.close();
		} catch (Exception e) {
			throw new RuntimeException("Writer RuntimeException");
		}
	}
}
