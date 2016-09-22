package ch18.exam04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderExample {
	public static void main(String[] args) throws IOException{
		Reader reader = new FileReader("src/ch18/exam04/data.txt");
		String data = "";
		int value = -1;
		while((value = reader.read()) != -1){
			char ch = (char) value;
			data += ch;
		}
		reader.close();
		System.out.println(data);
		
		reader = new FileReader("src/ch18/exam04/data.txt");
		data = "";
		char[] values = new char[2]; //두 글자씩 읽음
		int charNum = -1;
		while((charNum = reader.read(values)) != -1){
			data += new String(values, 0, charNum); //읽은 문자 수만큼 추가
		}
		reader.close();
		System.out.println(data);
	}
}
