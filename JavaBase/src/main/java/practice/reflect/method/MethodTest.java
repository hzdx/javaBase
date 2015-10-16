package practice.reflect.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 利用反射调用类中的方法
 * @author ldm
 *
 */
public class MethodTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Person p = new Person("aaa");
		Method method = p.getClass().getMethod("speak", null); //getMethod中传方法名和参数类型
		method.invoke(p, null);   //invoke传要动作的对象和方法参数的值
	}

	private static class Person{
		private String name;
		public Person(String name){
			this.name = name;
		}
		public void speak(){
			System.out.println("the person's name is :"+name);
		}
	}
}
