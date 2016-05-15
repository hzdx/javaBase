package concurrent.queue;

public class AtomicTest {

	public static void main(String[] args) {
		new Thread(new BarWorker("aaa")).start();
		new BarWorker("bbb").run();

	}

}
