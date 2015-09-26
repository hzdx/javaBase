package jdk8.testInterface;

public interface JDK8Interface {

	public static void sayHi(){
		System.out.println("接口中的静态方法");
	}
	
	public default void defalutMethod(){
		System.out.println("接口中的默认方法");
	}
}
