package io.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	public static void consMethod() {
		File f1 = new File("a.txt");
		File f2 = new File("c:\\abc", "b.txt");
		File d = new File("c:\\abc");
		File f3 = new File(d, "c.txt");
		sop("f1:" + f1);
		sop("f2:" + f2);
		sop("f3:" + f3);
		File f4 = new File("c:" + File.separator + "abc" + File.separator + "zzz" + File.separator + "a.txt");
	}

	public static void main(String[] args) throws IOException {
		method_3();
	}

	public static void method_1() throws IOException {
		File f = new File("a.txt");
		sop("exists:" + f.exists());
		sop("create:" + f.createNewFile());

		// f.deleteOnExit();

		sop("execute:" + f.canExecute());
		// sop("delete:"+f.delete());
	}

	public static void method_2() {
		File dir = new File("abc");
		sop("mkdir:" + dir.mkdir());
	}

	public static void method_3() throws IOException {
		File f = new File("d:\\java lianxi\\day20\\file.txt");
		f.createNewFile();
		sop("dir:" + f.isDirectory());
		sop("file:" + f.isFile());
		sop(f.isAbsolute());
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}
