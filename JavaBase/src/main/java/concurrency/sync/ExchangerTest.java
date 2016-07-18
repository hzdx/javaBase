package concurrency.sync;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger可以在两个线程之间交换数据，只能是2个线程。<br>
 * 当线程A调用Exchange对象的exchange()方法后，他会陷入阻塞状态，直到线程B也调用了exchange()方法，<br>
 * 然后以线程安全的方式交换数据，之后线程A和B继续运行
 *
 */
public class ExchangerTest {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		final Exchanger<String> exchanger = new Exchanger<String>();
		executor.execute(new Runnable() {
			String data1 = "abc";

			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + "正在把数据 " + data1 + " 交换出去");
					Thread.sleep((long) (Math.random() * 1000));
					String data2 = exchanger.exchange(data1);
					System.out.println(Thread.currentThread().getName() + "交换数据 到  " + data2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		executor.execute(new Runnable() {
			String data1 = "def";

			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + "正在把数据 " + data1 + " 交换出去");
					Thread.sleep((long) (Math.random() * 1000));

					String data2 = exchanger.exchange(data1);
					System.out.println(Thread.currentThread().getName() + "交换数据 到  " + data2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		executor.shutdown();
	}

}