package study.base.util;

class StringDemo {
	public static void main(String[] args) {
		String str = "abcdeiadlfili";
		sop(str.length());
		sop(str.charAt(5));
		sop(str.indexOf('a', 3));
		sop(str.lastIndexOf("d"));
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}
