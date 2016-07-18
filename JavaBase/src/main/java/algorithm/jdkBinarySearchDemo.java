package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class jdkBinarySearchDemo {
	public static void main(String[] args) {
		@SuppressWarnings("serial")
		List<String> list = new ArrayList<String>() {
			{
				add("abcd");
				add("aaa");
				add("zz");//
				add("kkkkk");
				add("qq");
				add("z");
			}
		};

		Collections.sort(list);
		sop(list);// [aaa, abcd, kkkkk, qq, z, zz]
		int index = Collections.binarySearch(list, "zz");
		sop("index=" + index);// 5
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}