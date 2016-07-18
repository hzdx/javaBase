package concurrency;

/**
 * join方法用线程对象调用，如果在一个线程A中调用另一个线程B的join方法，线程A将会等待线程B执行完毕后再执行。<br>
 * yield可以直接用Thread类调用，yield让出CPU执行权给同等级的线程，<br>
 * 如果没有相同级别的线程在等待CPU的执行权，则该线程继续执行。
 *
 */
public class JoinDemo {
	public static void main(String[] args) throws Exception {
		YieldDemo d = new YieldDemo();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();
		// t1.setPriority(Thread.MIN_PRIORITY);
		t2.start();
		// t1.join();
		for (int x = 0; x < 80; x++) {
			// System.out.println(Thread.currentThread().getName()+"....."+x);
		}
		System.out.println("over");
	}

}

class YieldDemo implements Runnable {
	@Override
	public void run() {
		for (int x = 0; x < 70; x++) {
			System.out.println(Thread.currentThread().toString() + "....." + x);
			Thread.yield();
		}
	}
}