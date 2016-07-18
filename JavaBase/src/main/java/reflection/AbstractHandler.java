package reflection;

import java.lang.reflect.Method;

public interface AbstractHandler {

	public abstract void afterMethod();

	public abstract void beforeMethod();

	public abstract Object invoke(Object obj, Method method, Object[] args) throws Throwable;

}