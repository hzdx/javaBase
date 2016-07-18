package concurrency.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTest {
	Lock lock = new ReentrantLock(true);

	// synchronized
	void printNum() {
		lock.lock();
		try {
			System.out.print(1 + " ...");
			System.out.print(2 + " ...");
			System.out.print(3 + " ...");
			System.out.println(4);
		} finally {
			lock.unlock();
		}
	}

	// synchronized
	void printChar() {
		lock.lock();
		try {
			System.out.print("a  ...");
			System.out.print("b  ...");
			System.out.print("c ...");
			System.out.println("d");
		} finally {
			lock.unlock();
		}
	}

	// 同一个对象 两个不同的synchronized修饰的方法间 同步(都是锁的对象本身，两个方法同时只有一个线程可以进入)
	// 使用synchronized 同一个线程很容易连续获取锁。即连续同一个线程获取锁，总是同一个线程在执行同步代码块。
	// 使用Lock lock = new ReentrantLock(true); 线程的执行很均匀，这里两个线程交替执行，但会降低一点性能
	public static void main(String[] args) {
		final SyncTest sync = new SyncTest();
		Runnable run1 = new Runnable() {
			@Override
			public void run() {
				for (;;)
					sync.printNum();
			}

		};

		Runnable run2 = new Runnable() {
			@Override
			public void run() {
				for (;;)
					sync.printChar();
			}

		};

		new Thread(run1).start();
		new Thread(run2).start();

	}

}
