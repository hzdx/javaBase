package io.file;

import java.io.File;

public class FileListTest {
	public static void listDemo() {
		File dir = new File("d:\\");
		File[] files = dir.listFiles();
		for (File f : files) {
			System.out.println(f.getName() + "::" + f.length());
		}
	}

	public static void listRootsDemo() {
		File[] files = File.listRoots();
		for (File f : files) {
			System.out.println(f);
		}
	}

	public static void main(String[] args) {
		listRootsDemo();
		listDemo();
	}
}
