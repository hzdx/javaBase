package study.base.generic;

class Demo {
	public <T> void show(T t) {
		System.out.println("show:" + t);
	}

	public <Q> void print(Q q) {
		System.out.println("print:" + q);
	}

	public static <T> void method(T t) {
		System.out.println("method:" + t);
	}
}

class GenericDemo2 {
	public static void main(String[] args) {
		Demo d = new Demo();
		d.show("haha");
		d.show(4);
		d.print('h');
		d.print(new Integer(3));
		d.method("hahahahha");
		d.method(111);
	}
}