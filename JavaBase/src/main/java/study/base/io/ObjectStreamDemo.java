package study.base.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class ObjectStreamDemo {
	public static void main(String[] args) throws Exception {
		writeObj();
		readObj();
	}

	public static void readObj() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"obj.txt"));
		Person p = (Person) ois.readObject();
		System.out.println(p);
		ois.close();
	}

	public static void writeObj() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"obj.txt"));
		oos.writeObject(new Person("lisi01", 39, "usa"));
		oos.close();
	}
}