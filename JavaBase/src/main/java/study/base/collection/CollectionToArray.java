package study.base.collection;

import java.util.ArrayList;
import java.util.Arrays;

class CollectionToArray {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("abc1");
		al.add("abc2");
		al.add("abc3");
		String[] arr = al.toArray(new String[al.size()]);
		System.out.println(Arrays.toString(arr)); // [abc1, abc2, abc3]
	}
}