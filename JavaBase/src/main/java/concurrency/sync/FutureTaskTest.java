package concurrency.sync;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<String> caller = new Callable<String>() {
			@Override
			public String call() {
				System.out.println("sub thread run ...");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
				}
				System.out.println("sub thread end ...");
				return "ok";
			}

		};
		FutureTask<String> task = new FutureTask<String>(caller);
		new Thread(task).start();// 用thread或者线程池的方式启动
		Thread.sleep(1000);
		System.out.println("aaa");
		System.out.println(task.get());

	}

}
