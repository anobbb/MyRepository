package ch18.exam11;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {
	public static void main(String[] args) throws IOException{
		InputStream is = System.in;
				
		/*char data = (char)is.read(); //1바이트, but 한글은 2바이트
		System.out.println(data);*/
		
		/*byte[] values = new byte[100];
		int byteNum = is.read(values);
		String data = new String(values, 0, byteNum-2);
		System.out.println(data);*/
		
		Reader reader = new InputStreamReader(is);
		char data = (char) reader.read();
		System.out.println(data);
		
	}
}
