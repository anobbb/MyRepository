package ch18.exam12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
	public static void main(String[] args) throws IOException{
		
		long start = 0;
		long end = 0;
		
		FileReader fr = new FileReader("src/ch18/exam12/Daum.html");
		start = System.nanoTime();
		while(fr.read() != -1){ }
		end = System.nanoTime();
		System.out.println(end - start);
		
		
		FileReader fr2 = new FileReader("src/ch18/exam12/Daum.html");
		BufferedReader bis = new BufferedReader(fr2);
		
		start = System.nanoTime();
		while(bis.read() != -1){ }
		end = System.nanoTime();
		System.out.println(end - start);
		
	}
}
