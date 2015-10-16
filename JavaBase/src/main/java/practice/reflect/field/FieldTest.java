package practice.reflect.field;

import java.lang.reflect.Field;
/**
 * 利用反射中的field获取成员变量
 */
public class FieldTest {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		Point p = new Point(1,2);
		Field fieldX  = p.getClass().getField("x");  //只能获取公有的变量
		//变量是p对象上的对象，所有要用get方法得到变量的值
		System.out.println(fieldX.get(p));
		
		Field fieldX1  = p.getClass().getDeclaredField("y"); //所有声明的变量
		//y是私有成员变量，需要暴力破解
		fieldX1.setAccessible(true);		
		System.out.println(fieldX1.get(p));
	}

	private static class Point{
		public int x;
		private int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
}
