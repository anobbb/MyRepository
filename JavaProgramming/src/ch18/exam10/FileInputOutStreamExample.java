package ch18.exam10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutStreamExample {
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("src/ch18/exam10/Penguins.jpg");
		FileOutputStream fos = new FileOutputStream("src/ch18/exam10/Penguins2.jpg");
		
		byte[] values = new byte[1024];
		int byteNum;
		while((byteNum = fis.read(values)) != -1){
			fos.write(values, 0, byteNum);
		}
		fos.flush();
		
		fis.close();
		fos.close();
	}
}
