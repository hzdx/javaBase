package concurrency.sync;

public class AsyncTest {
	long timeout;
	String data;

	AsyncTest(String data) {
		this.data = data;
	}

	String start() {
		AsyncTask task = new AsyncTask(data, 5000);
		// return task.fetchResult();
		return task.fetchResultWithLoop();
	}

	public static void main(String[] args) {
		AsyncTest test = new AsyncTest("test");
		System.out.println(test.start());

	}

}
