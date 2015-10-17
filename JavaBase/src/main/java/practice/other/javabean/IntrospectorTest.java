package practice.other.javabean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过PropertyDescriptor，获取属性的get,set方法，再用反射进行操作
 * 
 * @author ldm
 *
 */
public class IntrospectorTest {

	public static void main(String[] args) throws IntrospectionException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {

		Point p = new Point();
		p.setX(1);
		String propertyName = "x";
		System.out.println(getProperty(p, propertyName));

		setProperty(p, propertyName);
		System.out.println(getProperty(p, propertyName));
	}

	private static void setProperty(Point p, String propertyName)
			throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		// 通过获取beanInfo，在获取PropertyDescriptor数组，在依次比较，较复杂
		BeanInfo beanInfo = Introspector.getBeanInfo(p.getClass());
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			if (pd.getName().equals(propertyName)) {
				Method methodset = pd.getWriteMethod();
				methodset.invoke(p, 2);
				break;
			}
		}
	}

	// PropertyDescriptor方式获取方法,通过属性名x获取javaBean的getX（）方法
	private static Object getProperty(Point p, String propertyName)
			throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor(propertyName,
				p.getClass());
		Method methodget = pd.getReadMethod();
		return methodget.invoke(p, null);
	}

	private static class Point {
		private int x;
		private int y;

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}
}
