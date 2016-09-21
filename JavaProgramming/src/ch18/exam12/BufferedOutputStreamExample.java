package ch18.exam12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {
	public static void main(String[] args) throws IOException{
		long start = 0;
		long end = 0;
		
		//----------------------------------------------------------------------
		FileInputStream fis = new FileInputStream("src/ch18/exam10/Penguins.jpg");
		FileOutputStream fos = new FileOutputStream("src/ch18/exam10/Penguins2.jpg");
		
		int value;
		start = System.currentTimeMillis();
		while((value = fis.read()) != -1){
			fos.write(value);
		}
		fos.flush();
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		fis.close();
		fos.close();
		//----------------------------------------------------------------------
		FileInputStream fis2 = new FileInputStream("src/ch18/exam10/Penguins.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		
		FileOutputStream fos2 = new FileOutputStream("src/ch18/exam10/Penguins2.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		start = System.currentTimeMillis();
		while((value = bis.read()) != -1){
			bos.write(value);
		}
		bos.flush();
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		bis.close();
		bos.close();
	}
}
