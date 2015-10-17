package study.base.util;

import java.util.Properties;

class SystemDemo {
	public static void main(String[] args) {
		Properties prop = System.getProperties();
		System.setProperty("mykey", "myvalue");
		System.out.println(System.getProperty("mykey"));
		String value = System.getProperty("os.name");
		System.out.println("value=" + value);
		String v = System.getProperty("haha");
		System.out.println("v=" + v);
		/*
		 * for(Object obj:prop.keySet()) { String value = (String)prop.get(obj);
		 * System.out.println(obj+"::"+value); }
		 */
	}
}