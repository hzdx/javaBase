package oop;

public class InnerClassTest {
	public static void main(String[] args) {
		Test.function().method();
	}
}

interface Inter {
	void method();
}

class Test {
	/*
	 * static class Inner implements Inter { public method() {
	 * System.out.println("method run"); } }
	 */
	static Inter function() {
		return new Inter() {
			@Override
			public void method() {
				System.out.println("method run");
			}
		};
	}

}
