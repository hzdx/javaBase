package practice.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Hander implements InvocationHandler, AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see proxy.AbstractHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object obj, Method method, Object[] args)
			throws Throwable {
		beforeMethod();
		Object returnValue = method.invoke(obj, args);
		afterMethod();
		return returnValue;
	}

	long beganTime = System.currentTimeMillis();

	/*
	 * (non-Javadoc)
	 * 
	 * @see proxy.AbstractHandler#beforeMethod()
	 */
	@Override
	public void beforeMethod() {
		System.out.println("befor method performed...");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see proxy.AbstractHandler#afterMethod()
	 */
	@Override
	public void afterMethod() {
		System.out.println("after method performed...");
		System.out.println("method cost:"
				+ (System.currentTimeMillis() - beganTime));
	}
}
