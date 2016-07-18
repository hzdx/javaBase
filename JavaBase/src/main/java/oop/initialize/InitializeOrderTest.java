package oop.initialize;

/**
 * 初始化过程：父类静态->子类静态->父类初始化常量，代码块->父类构造方法 ->子类初始化常量，代码块->子类构造方法
 *
 * 总结：静态代码块总是最先执行。 非静态代码块跟非静态方法一样，跟对象有关。只不过非静态代码块在构造函数之前执行。
 * 父类非静态代码块、构造函数执行完毕后（相当于父类对象初始化完成）， 才开始执行子类的非静态代码块和构造函数。
 */
public class InitializeOrderTest {

	public static void main(String[] args) {
		// Child child = new Child();
		Parrent par = new Child();

	}

}
