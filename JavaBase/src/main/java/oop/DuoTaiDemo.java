package oop;

/*
 1，多态的体现
 父类的引用指向了自己的子类对象。
 父类的引用也可以接受自己的子类对象。
 2，多态的前提
 必须是类与类之间有关系，要么继承，要么实现。
 通常还有一个前提：存在覆盖。
 3.好处提高了程序扩展性，但只能引用父类的引用访问父类的成员。
 */
class Animal {
	public void eat() {
	}
}

class Cat extends Animal {
	public void catchMouse() {
		System.out.println("catch Mouse");
	}

	@Override
	public void eat() {
		System.out.println("eat");
	}
}

public class DuoTaiDemo {
	public static void function(Animal a) {
		a.eat();
		if (a instanceof Cat) {
			Cat c = (Cat) a;// 强制将父类的引用，转成子类类型。向下转型。
			c.catchMouse();
		}

	}

	public static void main(String[] args) {
		Animal a = new Cat();
		function(a);
	}
}

/*
 * 子类继承父类，方法相同不用写。 成员函数在多态调用时，编译看左边，运行看右边 在多态中，成员变量的特点：无论编译还是运行，都看左边。(引用型变量所属的类)
 * 静态成员函数无论编译和运行都参考左边。
 * 
 * Object 是所有对象的直接后者间接父类。 该类中定义的肯定是所有对象都具有的功能。 object的equals方法其实是比较地址。 toString
 * getClass().getName() + '@' + Integer.toHexString(hashCode())
 */