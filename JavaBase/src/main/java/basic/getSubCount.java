package basic;

public class getSubCount {
	public static int getSubCount(String str, String key) {
		int count = 0;
		int index = 0;
		while ((index = str.indexOf(key)) != -1) {
			str = str.substring(index + key.length());
			sop("str=" + str);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		String s = "qi22rro22quqr22ot41";
		sop("count=" + getSubCount(s, "22"));
	}

	public static void sop(String str) {
		System.out.println(str);
	}
}