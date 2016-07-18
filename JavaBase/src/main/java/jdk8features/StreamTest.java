package jdk8features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add(1);
		Stream<Object> stream = list.stream();
		stream.forEach(s -> System.out.println(s.toString()));

	}

}
