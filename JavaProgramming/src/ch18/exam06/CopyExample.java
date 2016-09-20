package ch18.exam06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyExample {
	public static void main(String[] args) throws IOException{
		Reader reader = new FileReader("src/ch18/exam06/data.txt");
		Writer writer = new FileWriter("src/ch18/exam06/data2.txt");
		
		char[] values = new char[100];
		int charNum = -1;
		while((charNum = reader.read(values)) != -1){ //100자 중 실제로 읽은 문자 수
			writer.write(values, 0, charNum);		
		}
		writer.flush();
		
		writer.close();
		reader.close();
	}
}
