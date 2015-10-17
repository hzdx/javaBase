package practice.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyFramworkDemo {

	public static void main(String[] args) {
		List list = new ArrayList();
		List proxyList = (List) getProxy(list, new MyAdvice());
		System.out.println(proxyList.getClass().getName());
		proxyList.clear();
		proxyList.add(1);
		System.out.println(proxyList.size());

	}

	private static Object getProxy(final Object obj, final Advice advice) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)// 传入代理类实例
					throws Throwable {
				advice.beforeMethod(method);
				Object returnValue = method.invoke(obj, args); // 调用目标类的方法
				advice.afterMethod(method);
				return returnValue;
			}
		});
	}

}
