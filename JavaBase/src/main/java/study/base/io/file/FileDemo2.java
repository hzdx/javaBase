package study.base.io.file;

import java.io.File;
import java.io.IOException;

class FileDemo2 {
	public static void main(String[] args) throws IOException {
		method_3();
	}

	public static void method_3() throws IOException {
		File f = new File("d:\\java lianxi\\day20\\file.txt");
		f.createNewFile();
		sop("dir:" + f.isDirectory());
		sop("file:" + f.isFile());
		sop(f.isAbsolute());
	}

	public static void method_2() {
		File dir = new File("abc");
		sop("mkdir:" + dir.mkdir());
	}

	public static void method_1() throws IOException {
		File f = new File("a.txt");
		sop("exists:" + f.exists());
		sop("create:" + f.createNewFile());

		// f.deleteOnExit();

		sop("execute:" + f.canExecute());
		// sop("delete:"+f.delete());
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}
