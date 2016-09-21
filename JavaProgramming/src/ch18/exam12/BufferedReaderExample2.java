package ch18.exam12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample2 {
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("src/ch18/exam12/Daum.html");
		BufferedReader br = new BufferedReader(fr);
		
		int count = 0;
		while(true){
			String line = br.readLine();
			//행 단위로 읽다가 없으면 null
			if(line == null) break;
			System.out.println( (++count) + ": " + line);
		}
	}
}
