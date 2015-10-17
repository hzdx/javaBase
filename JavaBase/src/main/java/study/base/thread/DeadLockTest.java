package study.base.thread;

class Te1st implements Runnable {
	private boolean flag;

	Te1st(boolean flag) {
		this.flag = flag;
	}

	public void run() {
		if (flag) {
			while (true) {
				synchronized (MyLock.locka) {
					System.out.println("if locka");
					synchronized (MyLock.lockb) {
						System.out.println("if lockb");
					}
				}
			}
		} else {
			while (true) {
				synchronized (MyLock.lockb) {
					System.out.println("else lockb");
					synchronized (MyLock.locka) {
						System.out.println("else locka");
					}
				}
			}
		}
	}
}

class MyLock {
	static Object locka = new Object();
	static Object lockb = new Object();
}

class DeadLockTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Te1st(true));
		Thread t2 = new Thread(new Te1st(false));
		t1.start();
		t2.start();
	}
}