package ch18.exam13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamExample {
	public static void main(String[] args) throws IOException{
		FileOutputStream fos = new FileOutputStream("src/ch18/exam13/data.db");
		
		int v1 = 100;
		boolean v2 = true;
		double v3 = 5.3;
		String v4 = "java";
		
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeInt(v1);
		dos.writeBoolean(v2);
		dos.writeDouble(v3);
		dos.writeUTF(v4);
		
		dos.flush();
		//dos.close();
		fos.close();
		
		//<----------------------------------------------------------->
		
		FileInputStream fis = new FileInputStream("src/ch18/exam13/data.db");
		DataInputStream dis = new DataInputStream(fis);
		
		int v5 = dis.readInt();
		boolean v6 = dis.readBoolean();
		double v7 = dis.readDouble();
		String v8 = dis.readUTF();
		
		System.out.println(v5);
		System.out.println(v6);
		System.out.println(v7);
		System.out.println(v8);
	}
}
