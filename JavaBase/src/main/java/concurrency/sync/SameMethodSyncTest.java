package concurrency.sync;

public class SameMethodSyncTest {

	synchronized void hand() {
		System.out.print("1--");
		System.out.print("2--");

		try {
			wait();// 释放了锁，其他的线程可以进入这个synchronized方法了
			// 最好用放在while()循环块里，用一个标志变量作为结束等待的标记。
		} catch (InterruptedException e) {
		}
		System.out.print("3--");
		System.out.print("4--");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
		}
		System.out.println("5");
	}

	synchronized void waken() {
		// notify();//只有一个线程能结束wait();
		notifyAll();
		// 这里全部唤醒了，上面hand方法wait()后面的代码
		// 也只有一个线程能执行，不能两个线程同时执行
	}

	public static void main(String[] args) throws InterruptedException {
		final SameMethodSyncTest sync = new SameMethodSyncTest();
		new Thread(new Runnable() {
			@Override
			public void run() {
				sync.hand();
			}

		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				sync.hand();
			}

		}).start();

		// 1--2--1--2-
		Thread.sleep(2000);
		System.out.println("start to waken..");

		sync.waken();

	}

}
