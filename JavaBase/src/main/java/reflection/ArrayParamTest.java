package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ArrayParamTest {

	private static void call(String[] strs) {
		System.out.println("call is invoked");
		for (String str : strs) {
			System.out.println(str);
		}
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Method callMethod = ArrayParamTest.class.getDeclaredMethod("call", String[].class);
		callMethod.invoke(null, (Object) new String[] { "aaa", "bbb" });
		// 由于要兼容老版本jdk，所以传参为String[]时，要强转为Object对象.
	}
}
