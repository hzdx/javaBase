package reflection;

/**
 * 可变参数测试
 * 
 *
 */
public class Param {
	// 可变参数在方法体中当作数组处理
	private static int add(int... param) {
		int sum = 0;
		/* for(int i=0;i<param.length;i++){ */
		for (int i : param) {
			sum += i;
		}
		return sum;
	}

	public static String link(String str, String... strings) {
		StringBuffer sb = new StringBuffer(str);
		for (int i = 0; i < strings.length; i++) {
			sb.append(strings[i]);
			sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(add(2, 3));
		System.out.println(add(2, 3, 4, 5));
		System.out.println(add(add(2, 3, 4), 6));
		System.out.println(link("aaa", "bbb", "ccc"));
	}

}
