package concurrency;

public class ThreadTest {
	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				for (int x = 0; x < 60; x++)
					System.out.println(Thread.currentThread().getName() + "..." + x);
			}
		}.start();
		for (int x = 0; x < 60; x++)
			System.out.println(Thread.currentThread().getName() + "..." + x);
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int x = 0; x < 60; x++)
					System.out.println(Thread.currentThread().getName() + "..." + x);
			}
		};
		new Thread(r).start();
	}
}