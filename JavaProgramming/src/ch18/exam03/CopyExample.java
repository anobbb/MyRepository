package ch18.exam03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
	public static void main(String[] args) throws IOException{
		InputStream is = new FileInputStream("src/ch18/exam03/Penguins.jpg");
		OutputStream os = new FileOutputStream("src/ch18/exam03/Penguins2.jpg");
		
		byte[] values = new byte[1024];
		int byteNum = -1;
		
		while((byteNum = is.read(values)) != -1){
			os.write(values, 0, byteNum);
		}
		
		os.flush();
		os.close();
		is.close();
	}
}
