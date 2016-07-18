package concurrency.sync;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicTest {
	public static AtomicBoolean islocked = new AtomicBoolean(false);

	public static void work() {
		// 使用AtomicBoolean构造同步代码块
		// 会顿卡一下 可能是因为多线程重复执行compareAndSet指令
		while (true) {
			if (islocked.compareAndSet(false, true)) {
				System.out.print(Thread.currentThread().getName() + "..");
				System.out.print("step 1..");
				System.out.print("step 2..");
				System.out.print("step 3..");
				System.out.print("step 4..");
				System.out.println("step 5..");
				islocked.set(false);
				break;
			}
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true)
						work();
				}

			}).start();
		}

	}

}
