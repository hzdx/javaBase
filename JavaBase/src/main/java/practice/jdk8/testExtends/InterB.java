package practice.jdk8.testExtends;

public interface InterB {
	public default void sayHi() {
		System.out.println("这是B接口的默认方法");
	}

}
