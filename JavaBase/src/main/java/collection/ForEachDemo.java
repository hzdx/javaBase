package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ForEachDemo {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		for (String s : al)
			System.out.println(s);
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "a");
		hm.put(2, "b");
		hm.put(3, "c");
		Set<Integer> keySet = hm.keySet();
		for (Integer i : keySet) {
			System.out.println(i + "::" + hm.get(i));
		}
	}
}