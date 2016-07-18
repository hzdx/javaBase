package basic;

public class PointerDelivery {
	public static void main(String[] args) {
		PointerDelivery ex = new PointerDelivery();
		ex.change(ex.str, ex.ch);
		System.out.print(ex.str + "and");
		System.out.print(ex.ch);
		// 参考答案输出结果：goodandgbc
	}

	String str = new String("good");

	char[] ch = { 'a', 'b', 'c' };

	// 传值传的只是指针的拷贝，Java无法改变指针的地址。
	public void change(String str, char ch[]) {
		// str是指针的拷贝指向了另外的地址，java是无法改变指针的地址的。
		str = "test ok";
		// ch改变了对象内部的元素，所有原来指针指向的对象内部改变了。
		ch[0] = 'g';
	}
}