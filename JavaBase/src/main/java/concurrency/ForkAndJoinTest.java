package concurrency;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 在Fork/Join框架中，提交任务的时候，有同步和异步两种方式。以前使用的invokeAll()的方法是同步的，也就是任<br>
 * 务提交后，这个方法不会返回直到所有的任务都处理完了。而还有另一种方式，就是使用fork方法，这个是异步的。也<br>
 * 就是你提交任务后，fork方法立即返回，可以继续下面的任务。
 *
 */
public class ForkAndJoinTest extends RecursiveTask<List<String>> {

	private static final long serialVersionUID = 1L;

	private String path;
	private String extension;

	public ForkAndJoinTest(String path, String extension) {
		super();
		this.path = path;
		this.extension = extension;
	}

	@Override
	protected List<String> compute() {
		List<String> list = new ArrayList<String>();
		List<ForkAndJoinTest> tasks = new ArrayList<ForkAndJoinTest>();
		File file = new File(path);
		File content[] = file.listFiles();
		if (content != null) {
			for (int i = 0; i < content.length; i++) {
				if (content[i].isDirectory()) {
					ForkAndJoinTest task = new ForkAndJoinTest(content[i].getAbsolutePath(), extension);
					// 异步方式提交任务
					task.fork();
					// This method sends the task to the pool that will execute
					// it
					// if it has a free worker-thread or it can create a new one
					tasks.add(task);
				} else {
					if (checkFile(content[i].getName())) {
						list.add(content[i].getAbsolutePath());
					}
				}
			}
		}
		if (tasks.size() > 50) {
			System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
		}

		addResultsFromTasks(list, tasks);
		return list;
	}

	/**
	 * that will add to the list of files the results returned by the subtasks
	 * launched by this task.
	 * 
	 * @param list
	 * @param tasks
	 */
	private void addResultsFromTasks(List<String> list, List<ForkAndJoinTest> tasks) {
		for (ForkAndJoinTest item : tasks) {
			list.addAll(item.join());
		}
	}

	/**
	 * This method compares if the name of a file passed as a parameter ends
	 * with the extension you are looking for
	 * 
	 * @param name
	 * @return
	 */
	private boolean checkFile(String name) {
		return name.endsWith(extension);
	}

	/**
	 * 以一个查询磁盘的以log结尾的文件的程序例子来说明异步的用法
	 */
	// ForkJoinPool适合这种迭代 遍历树 的工作
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		// 默认线程数为cpu核心数
		ForkAndJoinTest system = new ForkAndJoinTest("C:\\Windows", "log");
		ForkAndJoinTest apps = new ForkAndJoinTest("C:\\Program Files", "log");

		pool.execute(system);
		// pool.execute(apps);

		pool.shutdown();

		List<String> results = null;
		results = system.join();
		System.out.printf("System: %d files found.\n", results.size());
		for (String file : results)
			System.out.println(file);

		// results = apps.join();
		// System.out.printf("Apps: %d files found.\n", results.size());

	}
}