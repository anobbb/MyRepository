package ch18.exam09;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileExample3 {
	public static void main(String[] args) throws IOException{
		File root = new File("C:/");
		File[] contents = root.listFiles();
		
		for(File file : contents){
			if(file.isDirectory()){
				System.out.print("<DIR> \t");
			} else{
				System.out.print("\t");
				System.out.print(file.length());
			}
			System.out.print("\t\t");
			System.out.println(file.getName());
		}
	}
}
