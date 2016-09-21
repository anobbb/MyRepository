package ch18.exam12;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamExample {
	public static void main(String[] args) throws IOException{
		
		long start = 0;
		long end = 0;
		
		FileInputStream fis = new FileInputStream("src/ch18/exam12/Penguins.jpg");
		start = System.currentTimeMillis();
		while(fis.read() != -1){ }
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		
		FileInputStream fis2 = new FileInputStream("src/ch18/exam12/Penguins.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		
		start = System.currentTimeMillis();
		while(bis.read() != -1){ }
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
	}
}
