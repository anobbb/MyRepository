package ch11.exam10;

import java.io.IOException;

public class KeyboardToStringExample {

	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100];
		
		System.out.print("입력: ");
		int readByteNo = System.in.read(bytes); //읽은 바이트 수

		//String str = new String(bytes);
		String str = new String(bytes, 0, readByteNo-2); //enter: 2bytes
		System.out.println(str);
	}

}
