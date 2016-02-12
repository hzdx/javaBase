package study.base.io;

import java.io.IOException;
import java.io.RandomAccessFile;

class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		writeFile_2();
		// writeFile();
		// readFile();
//		RandomAccessFile raf = new RandomAccessFile("c:/temp/words.txt", "rw");
//		raf.writeInt(99);
	}

	public static void readFile() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("c:/temp/words.txt", "r");

		// ���������ָ��
		 raf.seek(8);//设置cusor位置

		// ���ָ�����ֽ���
		//raf.skipBytes(8);
		byte[] buf = new byte[4];
		raf.read(buf);
		String name = new String(buf);
		int age = raf.readInt();
		System.out.println("name=" + name);
		System.out.println("age=" + age);
		raf.close();
	}

	public static void writeFile_2() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("c:/temp/words.txt", "rw");
		raf.seek(8 * 3);//从指定字节位置开始写
		raf.write("hello".getBytes());
		//raf.writeInt(103);//写入int类型的值，高位被填充为null
		raf.close();
	}

	public static void writeFile() throws IOException {
		RandomAccessFile raf = new RandomAccessFile("c:/temp/words.txt", "rw");
		raf.write("insert".getBytes());
		raf.writeInt(97);
		raf.write("bbb".getBytes());
		raf.writeInt(99);
		raf.close();
	}
}