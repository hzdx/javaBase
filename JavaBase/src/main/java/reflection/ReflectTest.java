package reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 反射就是把java类中各种组成成分映射成相应的java类 如package包，field成员变量,method方法，constructor构造函数
 * 会使程序性能下降
 * 
 *
 */
public class ReflectTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Class clazz = Date.class; // 得到Date类的字节码
		System.out.println(clazz);
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getConstructor());
		System.out.println(clazz.isPrimitive()); // 是否是基本类型
		System.out.println(int.class.isPrimitive());
		// class-->constructor-->instance 有个默认constructor
		// Class.forName()等同于 String.getClass 都是加载字节码
		String str = (String) Class.forName("java.lang.String").getConstructor(null).newInstance();
		System.out.println(str);
		System.out.println("aaa".isEmpty());
		System.out.println(Date.class.newInstance());
		System.out.println(new String("aa"));
	}

}
