package concurrency;

/**
 * volatile修饰的变量,cpu不会使用核心内部缓存
 *
 */
public class VolatileTest {
	private static class ReadThread extends Thread {
		@Override
		public void run() {
			while (!ready)
				Thread.yield();
			System.out.println(number);
		}
	}

	private static int number;

	private static volatile boolean ready;
	// boolean类型的变量，默认是false

	public static void main(String[] args) throws InterruptedException {
		new ReadThread().start();
		number = 42;
		ready = true;
	}
}