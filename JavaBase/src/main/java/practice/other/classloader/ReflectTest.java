package practice.other.classloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
	public static void  main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//1.通过类装载器获取Item类对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println(loader.getClass().getName());
		Class clazz = loader.loadClass("classloader.Item");
		//2.使用类的默认构造器对象并通过它实例化对象
		Constructor cons = clazz.getDeclaredConstructor();
		Item item = (Item)cons.newInstance();
		//3.通过反射方法设置属性
		Method setId = clazz.getMethod("setId", Integer.class);
		setId.invoke(item, 5);
		System.out.println(item.getId());
	}

}
