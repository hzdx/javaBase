package reflection;

import java.lang.reflect.Field;

public class FieldPractice {

	private static class Person {
		private String name = "abcab";
		private String psw = "bcedbbb";

		@Override
		public String toString() {
			return "Person [name=" + name + ", psw=" + psw + "]";
		}

	}

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		Person p = new Person();
		System.out.println("转换之前的p对象：" + p);
		Field[] fields = p.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) { // 数组遍历也可用增强for循环
			fields[i].setAccessible(true);
			if (fields[i].getType() == String.class) { // fields[i].getType()获取字段类型
														// 字节码比较用==
				String s = (String) fields[i].get(p);
				fields[i].set(p, ((String) fields[i].get(p)).replace("b", "a"));
				;
			}
		}
		System.out.println("转换之后的p对象：" + p);
	}
}
