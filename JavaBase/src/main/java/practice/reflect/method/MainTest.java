package practice.reflect.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射调用别的类中的main方法
 * @author ldm
 *
 */
public class MainTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		//MethodTest test = new MethodTest();
		Method main = MethodTest.class.getMethod("main", String[].class);
		main.invoke(null, (Object)null); //传入main方法的参数当Object.
	}

}
