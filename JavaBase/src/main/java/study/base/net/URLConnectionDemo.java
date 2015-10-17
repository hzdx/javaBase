package study.base.net;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

class URLConnectionDemo {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.baidu.com/");

		URLConnection conn = url.openConnection();
		System.out.println(conn);

		InputStream in = conn.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf, 0, len));
	}
}
