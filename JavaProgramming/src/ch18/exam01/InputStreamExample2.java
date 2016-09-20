package ch18.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class InputStreamExample2 {
	public static void main(String[] args) throws IOException{
		String filePath = InputStreamExample2.class.getResource("data.txt").getPath();

		int count = 0;
		InputStream is = new FileInputStream(filePath);
		byte[] values = new byte[3];
		while(true){
			int byteNum = is.read(values);
			if(byteNum == -1) break;
			System.out.println(byteNum + ": " + Arrays.toString(values));
			count++;
		}
		System.out.println("읽은 회수: " + count);
		is.close();
				
		count = 0;
		is = new FileInputStream(filePath);
		values = new byte[3];
		int byteNum = -1;
		while((byteNum = is.read(values)) != -1){
			System.out.println(byteNum + ": " + Arrays.toString(values));
			count++;
		}
		System.out.println("읽은 회수: " + count);
		is.close();
	}
}
