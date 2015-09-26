package proxy;

import java.lang.reflect.Method;

public interface AbstractHandler{

	public abstract Object invoke(Object obj, Method method, Object[] args)
			throws Throwable;

	public abstract void beforeMethod();

	public abstract void afterMethod();

}