package study.base.io.file;

import java.io.File;

class FileDemo3 {
	public static void main(String[] args) {
		listRootsDemo();
	}

	public static void listDemo() {
		File f = new File("c:\\");
		String[] names = f.list();
		for (String name : names) {
			System.out.println(name);
		}
	}

	public static void listRootsDemo() {
		File[] files = File.listRoots();
		for (File f : files) {
			System.out.println(f);
		}
	}
}
