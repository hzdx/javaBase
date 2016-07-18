package jdk8features;

public class CImpl implements InterA, InterB {
	@Override
	public void sayHi() {
		System.out.println("这是C实现类的接口");
	}

}
