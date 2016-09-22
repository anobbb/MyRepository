package ch18.exam15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamExample {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("src/ch18/exam15/data.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Member member = new Member("angel", "김천사", "12345", 26);
		oos.writeObject(member);
		
		oos.flush();
		oos.close();
		fos.close();
		
	}
}
