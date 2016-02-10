package practice.jdk8.testLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add("aaa");
		list.add(1);
		list.forEach((t) -> System.out.println(t));

		// consumer(){} 功能性接口,只有一个accept方法，jdk8新增，为了使用lambda表达式。
		// @FunctionalInterface标注，只有一个接口，为了使用lambda表达式而创建
		list.forEach(new Consumer() {

			@Override
			public void accept(Object t) {
				System.out.println(t + "...aa");

			}
		});
	}
}
