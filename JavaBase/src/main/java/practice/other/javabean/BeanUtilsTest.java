package practice.other.javabean;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * 引入beanutils包和logging包来操作javaBean属性 javaBean的类必须声明为public才能成功
 * 
 * @author ldm
 *
 */
public class BeanUtilsTest {

	public static void main(String[] args) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		// TODO Auto-generated method stub
		Point p = new Point();
		BeanUtils.setProperty(p, "x", "8"); // beanutil自动进行类型转换，如果依次则为0
		System.out.println(BeanUtils.getProperty(p, "x"));
		System.out.println(PropertyUtils.getProperty(p, "x").getClass());
		// PropertyUtils不进行类型转换
		BeanUtils.setProperty(p, "birth.time", "111"); // beanutil自动进行级联，和EL表达式类似
		System.out.println(BeanUtils.getProperty(p, "birth"));

	}

	public static class Point {
		private Date birth;
		private int x;
		private int y;

		public Date getBirth() {
			return birth;
		}

		public void setBirth(Date birth) {
			this.birth = birth;
		}

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
