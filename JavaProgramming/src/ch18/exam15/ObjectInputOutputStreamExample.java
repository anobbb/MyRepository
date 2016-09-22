package ch18.exam15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamExample {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("src/ch18/exam15/data.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Member member = new Member("angel", "김천사", "12345", 26);
		oos.writeObject(member);
		
		oos.flush();
		oos.close();
		fos.close();
		
		//---------------------------------------------------------------
		//복원 = 데이터만 복원
		//member와 member2가 가리키는 객체는 다름
		
		FileInputStream fis = new FileInputStream("src/ch18/exam15/data.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Member member2 = (Member) ois.readObject();
		
		fis.close();
		ois.close();
		
		System.out.println(member2.getMid());
		System.out.println(member2.getMname());
		System.out.println(member2.getMpassword());
		System.out.println(member2.getMage());
		System.out.println(member2.getNation()); //복원이 아닌 클래스에 있는 data
		
	}
}
