package study.base.exception;

/*
 毕老师用电脑上课。
 开始思考上课中出现的问题。
 比如：
 电脑蓝屏
 电脑冒烟
 要对问题进行描述，封装成对象。

 */

class LanPingException extends Exception {
	LanPingException(String message) {
		super(message);
	}
}

class MaoYanException extends Exception {
	MaoYanException(String message) {
		super(message);
	}
}

class NoPlanException extends Exception {
	NoPlanException(String msg) {
		super(msg);
	}
}

class Computer {
	private int state = 3;

	public void run() throws LanPingException, MaoYanException {
		if (state == 2)
			throw new LanPingException("langping");
		if (state == 3)
			throw new MaoYanException("maoyan");
		System.out.println("computer run");
	}

	public void reset() {
		state = 1;
		System.out.println("computer reset");
	}
}

class Teacher {
	private String name;
	private Computer cmpt;

	Teacher(String name) {
		this.name = name;
		cmpt = new Computer();
	}

	public void prelect() throws NoPlanException {
		try {
			cmpt.run();

		} catch (LanPingException e) {
			cmpt.reset();

		} catch (MaoYanException e) {
			test();
			throw new NoPlanException("maoyan" + e.getMessage());

		}
		System.out.println("over");

	}

	public void test() {
		System.out.println("����ð��");
	}
}

class ExceptionTest {
	public static void main(String[] args) {
		Teacher t = new Teacher("aaa");
		try {
			t.prelect();
		} catch (NoPlanException e) {
			System.out.println(e.toString());
			System.out.println("nopan");
		}
	}
}
