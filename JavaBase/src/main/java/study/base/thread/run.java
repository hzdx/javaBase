package study.base.thread;

class Demo extends Thread {
	public void run() {
		for (int x = 0; x < 50; x++)
			System.out.println("demo run" + x);
	}
}

class ThreadDemo {
	public static void main(String[] args) {
		Demo d = new Demo();
		d.start();
		// d.run();
		for (int x = 0; x < 50; x++)
			System.out.println("hello,world" + x);
	}
}