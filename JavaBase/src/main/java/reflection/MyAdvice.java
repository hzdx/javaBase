package reflection;

import java.lang.reflect.Method;

public class MyAdvice implements Advice {
	long beginTime = 0;

	@Override
	public void afterMethod(Method method) {
		System.out.println("after method performed");
		System.out.println(method.getName() + " cost time:" + (System.currentTimeMillis() - beginTime));
	}

	@Override
	public void beforeMethod(Method method) {
		beginTime = System.currentTimeMillis();
		System.out.println("beform method performed!");
	}

}
