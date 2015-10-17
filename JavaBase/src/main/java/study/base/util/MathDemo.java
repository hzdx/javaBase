package study.base.util;

import java.util.Random;

class MathDemo {
	public static void main(String[] args) {
		Random r = new Random();
		for (int x = 0; x < 10; x++) {
			int d = r.nextInt(10) + 1;
			sop(d);
		}
		show();
	}

	public static void show() {
		double d = Math.ceil(16.34);
		double d1 = Math.floor(12.34);
		long l = Math.round(12.54);
		sop("d=" + d);
		sop("d1=" + d1);
		sop("l=" + l);
		double d2 = Math.pow(2, 3);
		sop("d2=" + d2);
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}