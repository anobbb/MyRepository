package ch18.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {
	public static void main(String[] args) throws IOException{
		String filePath = InputStreamExample.class.getResource("data.txt").getPath();

		int count = 0;
		InputStream is = new FileInputStream(filePath);
		while(true){
			int value = is.read();
			if(value == -1) break;
			System.out.println(value);
			count++;
		}
		System.out.println("읽은 회수: " + count);
		is.close();
		
		count = 0;
		is = new FileInputStream(filePath);
		int value = -1;
		while((value = is.read()) != -1){
			System.out.println(value);
			count++;
		}
		System.out.println("읽은 회수: " + count);
		is.close();
	}
}
