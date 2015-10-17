package study.base.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * 泛型测试 泛型只在编译时检查，利用放射可以绕过编译
 * 
 * @author ldm
 *
 */
public class GenericTest {

	public static void main(String[] args) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		// list.add("aaa");
		list.getClass().getMethod("add", Object.class).invoke(list, "aaa");
		System.out.println(list.get(0));

		Vector v1 = new Vector<String>();
		v1.add("bbb");
		Vector<Integer> v = v1;
		System.out.println(v.get(0));

		Map map = new HashMap();
		map.put("aaa", 1);
		map.put("bbb", 2);
		Set<Map.Entry> set = map.entrySet();
		for (Map.Entry entry : set) {
			System.out.println(entry.getKey() + ".." + entry.getValue());
		}

		Object obj = 11;
		int s = convert(obj);
		System.out.println(s);
	}

	private static <T> T convert(Object obj) { // 自定义泛型
		return (T) obj;
	}

}
