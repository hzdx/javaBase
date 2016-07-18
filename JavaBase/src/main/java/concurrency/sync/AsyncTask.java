package concurrency.sync;

public class AsyncTask implements Runnable {
	Thread thread;
	String input;
	volatile String result;
	long timeout;
	volatile boolean isCompleted = false;

	AsyncTask(String input, long timeout) {
		this.input = input;
		this.timeout = timeout;
		thread = new Thread(this);
		thread.setName("sub-thread");
	}

	/**
	 * sub-thread start... sub-thread sleep :5044 main wait timeout null
	 * sub-thread end...
	 */
	String fetchResultWithLoop() {// 可以用循环实现超时机制
		startThread();// 启动子线程获取结果
		for (int i = 0; i < 50; i++) {
			if (isCompleted)
				return result;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " wait timeout");
		// thread.interrupt();
		// 中断子线程报java.lang.InterruptedException: sleep interrupted
		// ,仍会打印sub-thread end语句
		return result;
	}

	/**
	 * main give data :test sub-thread start... sub-thread sleep :5254
	 * sub-thread end... main get result :test-sub-result test-sub-result
	 */
	synchronized String fetchResult() {
		System.out.println(Thread.currentThread().getName() + " give data :" + input);
		startThread();// 启动子线程获取结果
		// while(!isCompleted){
		try {
			wait(timeout);// 在子线程获取结果的过程中等待 ，timeout机制无效
		} catch (InterruptedException e) {
		}
		// }
		if (!isCompleted) {// 总是无效 子线程总是能执行完，估计跟在同步块内有关
			System.out.println(Thread.currentThread().getName() + " wait timeout");
			thread.interrupt();// 中断子线程无效
			// thread.destroy();
			// thread = null;
			return null;
		}
		String output = result;
		System.out.println(Thread.currentThread().getName() + " get result :" + output);
		return output;
	}

	void startThread() {
		thread.start();
	}

	@Override
	public void run() {
		generateResult();
	}

	synchronized void generateResult() {
		System.out.println(Thread.currentThread().getName() + " start...");
		long time = (long) ((Math.random() + 5) * 1000);
		System.out.println(Thread.currentThread().getName() + " sleep :" + time);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		result = input + "-sub-result";
		isCompleted = true;
		System.out.println(Thread.currentThread().getName() + " end...");
		notifyAll();
	}

}
