package basic;

public class reverseString {
	public static void main(String[] args) {
		String s = "qirroquqrot41";
		sop("(" + s + ")");
		sop("(" + reverseString(s) + ")");
		sop("(" + reverseString(s, 2, 5) + ")");
	}

	private static void reverse(char[] arr, int x, int y) {
		for (int start = x, end = y - 1; start < end; start++, end--) {
			swap(arr, start, end);
		}
	}

	public static String reverseString(String s) {
		return reverseString(s, 0, s.length());
	}

	public static String reverseString(String s, int start, int end) {
		char[] chs = s.toCharArray();
		reverse(chs, start, end);
		return new String(chs);
	}

	public static void sop(String str) {
		System.out.println(str);
	}

	private static void swap(char[] arr, int x, int y) {
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
