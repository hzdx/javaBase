package io.net;

import java.net.URL;

public class URLDemo {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://192.168.183.1:11000/myweb/demo.html?name=lisi");

		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		System.out.println(url.getFile());
		System.out.println(url.getQuery());

	}
}
