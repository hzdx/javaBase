package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Hander implements InvocationHandler, AbstractHandler {

	long beganTime = System.currentTimeMillis();

	/*
	 * 
	 */
	@Override
	public void afterMethod() {
		System.out.println("after method performed...");
		System.out.println("method cost:" + (System.currentTimeMillis() - beganTime));
	}

	/*
	 * 
	 */
	@Override
	public void beforeMethod() {
		System.out.println("befor method performed...");
	}

	@Override
	public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
		beforeMethod();
		Object returnValue = method.invoke(obj, args);
		afterMethod();
		return returnValue;
	}
}
