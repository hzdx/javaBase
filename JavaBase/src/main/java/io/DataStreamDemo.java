package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo {
	public static void main(String[] args) throws IOException {
		// writeData();
		readData();
	}

	public static void readData() throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
		int num = dis.readInt();
		boolean b = dis.readBoolean();
		double d = dis.readDouble();
		System.out.println("num=" + num + "...b=" + b + "...d=" + d);
	}

	public static void writeData() throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
		dos.writeInt(234);
		dos.writeBoolean(true);
		dos.writeDouble(9887.543);
		dos.close();
	}
}