package collection;

import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListTest {

	public static void main(String[] args) {
		String[] str = { "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "bbb", "ccc" };
		String[] clone = str.clone();
		clone = new String[] { "ddd", "eee" };
		System.out.println(clone.length);
		for (String stri : str) {
			System.out.println(stri);
		}
		// str.
		ArrayList list = new ArrayList();
		// System.out.print(list.ensureCapacity(20));
		// list.
		Vector vec = new Vector();
		System.out.println(vec.capacity());
		vec.ensureCapacity(20);
		System.out.println(vec.capacity());

		byte a = 5;
		int b = 10;
		int c = a >> 2 + b >> 2;
		System.out.println("c=" + c); // >>运算符的优先级比+低

		Pattern p = Pattern.compile("a*b");
		Matcher m = p.matcher("aaaaab");
		boolean bo = m.matches();
		System.out.println(bo);
	}

}
