package jdk8features;

public interface InterA {
	public default void sayHi() {
		System.out.println("这是A接口的默认方法");
	}

}
