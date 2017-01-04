package algorithm;

//实现数字不同进制间的转换，如 numberConvert(“100”, 10, 16) 返回的是100的16进制表示：64.
public class NumberConvert {
	public static void main(String[] args) {
		NumberConvert n = new NumberConvert();
		System.out.println(n.convertNumber("64", 16, 8));
		System.out.println(n.convertNumber("64", 16, 10));
	}

	public String convertNumber(String o_num_str, int o_base, int n_base) {
		if (o_base <= 0 || n_base <= 0)
			throw new IllegalArgumentException("不合法的进制!");
		int decimalNum = strToNum(o_num_str, o_base);
		return numToStr(decimalNum, n_base);
	}

	private String numToStr(int num, int base) {
		String s = "";
		int x = num;
		while (x > 0) {
			s = numToChar(x % base) + s;
			x = x / base;
		}
		return s;
	}

	private int strToNum(String numStr, int base) {
		int n = 0, b = 1;
		for (int i = numStr.length() - 1; i >= 0; i--) {
			n += charToNum(numStr.charAt(i)) * b;
			b *= base;
		}
		return n;
	}

	public int charToNum(char c) {
		if (c >= '0' && c <= '9')
			return c - '0';
		else
			return c - 'A' + 10;
	}

	public char numToChar(int n) {
		if (n >= 0 && n <= 9)
			return (char) (n + '0');
		else
			return (char) (n - 10 + 'A');
	}

}
