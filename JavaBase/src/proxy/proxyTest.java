package proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
/**
 * 代理
 * 动态生成Proxy类，继承了源接口和Object的方法
 * @author ldm
 *
 */
public class proxyTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = Proxy.getProxyClass(List.class.getClassLoader(), List.class);
		System.out.println(getCons(clazz));
	//	System.out.println(getMethods(clazz));
//		String itemCons = getCons(Item.class);
//		System.out.println(itemCons);
//		String itemMethods = getMethods(Item.class);
//		System.out.println(itemMethods);
		class MyInvocationHandler implements InvocationHandler{
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}}
		Constructor cons1 = clazz.getConstructor(InvocationHandler.class);
		List proxy1 = (List) cons1.newInstance(new MyInvocationHandler());
		System.out.println(proxy1);
		proxy1.clear();
		//proxy1.add("aa");
		
		List proxy2 = (List) cons1.newInstance(new InvocationHandler(){

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		
		List proxy3 = (List) Proxy.newProxyInstance(List.class.getClassLoader(), new Class[]{List.class}, new InvocationHandler() {
			ArrayList target = new ArrayList();	
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				long beganTime = System.currentTimeMillis();
				Object returnValue = method.invoke(target, args);
				System.out.println(method.getName()+" cost:"+(System.currentTimeMillis()-beganTime));
				return returnValue;
			}
		});
		proxy3.add("aa");
		proxy3.add("bbb");
		proxy3.add("cc");
		System.out.println(proxy3.size());
	}

	private static String getCons(Class clazz) {
		@SuppressWarnings("rawtypes")
		Constructor[] cons = clazz.getConstructors();
		StringBuilder sb = new StringBuilder();
		for(Constructor con:cons){
			sb.append(clazz.getSimpleName());
			sb.append("(");
			Class[] pramClasses = con.getParameterTypes();
			for(Class paramClass:pramClasses){
				sb.append(paramClass.getSimpleName());
				sb.append(",");
			}
			if(pramClasses!=null && pramClasses.length!=0) sb.deleteCharAt(sb.length()-1);
			//去掉最后一个,
			sb.append(")");
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private static String getMethods(Class clazz){
		Method[] methods = clazz.getMethods();
		StringBuilder sb = new StringBuilder();
		for(Method method:methods){
			sb.append(method.getName());
			sb.append("(");
			Class[] pramClasses = method.getParameterTypes();
			for(Class paramClass:pramClasses){
				sb.append(paramClass.getSimpleName());
				sb.append(",");
			}
			if(pramClasses!=null && pramClasses.length!=0) sb.deleteCharAt(sb.length()-1);
			//去掉最后一个,
			sb.append(")");
			sb.append("\n");
		}
		return sb.toString();
	}

}
