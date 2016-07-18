package concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

class MyTestDo {
	public static String doSome(String input) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		String output = input + ":" + (System.currentTimeMillis() / 1000);
		return output;
	}
}

public class SynchronousQueueTest {

	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(1);
		final SynchronousQueue<String> queue = new SynchronousQueue<String>();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						semaphore.acquire();
						String input = queue.take();
						String output = MyTestDo.doSome(input);
						System.out.println(Thread.currentThread().getName() + ":" + output);
						semaphore.release();
					} catch (InterruptedException e) {
					}
				}
			}).start();
		}

		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
		for (int i = 0; i < 10; i++) {
			String input = i + "";
			try {
				queue.put(input);
			} catch (InterruptedException e) {
			}
		}
	}
}
