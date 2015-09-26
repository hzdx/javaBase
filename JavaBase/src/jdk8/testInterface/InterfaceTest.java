package jdk8.testInterface;
/**
 * JDK8新特性1
 * 接口中可以有静态方法，直接用接口名调用
 * 接口中还可以有默认方法，需要用实现类调用，实现类也可以覆盖。
 * 如果一个实现类同时实现了A,B两个接口，且A,B具有相同的默认方法，则会编译报错，可以用覆盖来解决。
 * @author ldm
 *
 */
public class InterfaceTest {
	public static void main(String[] args) {
		JDK8Interface.sayHi();
		new JDK8Interface() {
		}.defalutMethod();
		
		JDK8InterImpl impl = new JDK8InterImpl();
		impl.defalutMethod();
		
		JDK8Interface impl1 = new JDK8InterImpl();
		impl1.defalutMethod();
		
	}

}
