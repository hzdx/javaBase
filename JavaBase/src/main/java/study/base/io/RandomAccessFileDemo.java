package study.base.io;

import java.io.IOException;
import java.io.RandomAccessFile;
class RandomAccessFileDemo
{
	public static void main(String[] args) throws IOException
	{
		//writeFile_2();
		//writeFile();
		//readFile();
		RandomAccessFile raf = new RandomAccessFile("ran1.txt","rw");
		raf.writeInt(99);
	}
	
	public static void readFile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","r");
		
		//���������ָ��
		//raf.seek(8);
		
		//���ָ�����ֽ���
		raf.skipBytes(8);
		byte[] buf = new byte[4];
		raf.read(buf);
		String name = new String(buf);
		int age = raf.readInt();
		System.out.println("name="+name);
		System.out.println("age="+age);
		raf.close();
	}
	
	public static void writeFile_2() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");
		raf.seek(8*3);
		raf.write("����".getBytes());
		raf.writeInt(103);
		raf.close();
	}
	
	public static void writeFile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");
		raf.write("����".getBytes());
		raf.writeInt(97);
		raf.write("����".getBytes());
		raf.writeInt(99);
		raf.close();
	}
}