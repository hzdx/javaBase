package study.base.generic;

interface Inter<T> {
	void show(T t);
}

class InterImpl<T> implements Inter<T> {
	public void show(T t) {
		System.out.println("show:" + t);
	}
}

class GenericDemo3 {
	public static void main(String[] args) {
		InterImpl<String> i = new InterImpl<String>();
		i.show("afjwljwfoiw");
	}
}