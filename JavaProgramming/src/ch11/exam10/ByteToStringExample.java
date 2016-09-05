package ch11.exam10;

import java.io.UnsupportedEncodingException;

public class ByteToStringExample {

	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 }; 
						//ASCII 코드 (0~255) [문자를 번호화]
		
		String str1 = new String(bytes); //문자로 변환
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
		
		//------------------------------------------------------------------
		
		String str3 = "홍길동";
		byte[] strBytes3 = str3.getBytes(); //한 문자를 2bytes Unicode로 읽어서 byte 배열에 저장
		String str4 = new String(strBytes3); //다시 string type으로 복원
		System.out.println(str4);
		
		/*String str5 = "홍길동";
		byte[] strBytes5= str5.getBytes("UTF-8"); //한 문자를 3bytes로 변환(encoding)하여 byte배열에 저장, 
		//String str6 = new String(strBytes5);
		String str6 = new String(strBytes5, "UTF-8"); //사용한 charset을 선언한 후 복원(decoding)
		System.out.println(str6);*/
		
		/*String str7 = "ab홍길동";
		byte[] strBytes7= str7.getBytes("EUC-KR"); 
		String str8 = new String(strBytes7, "EUC-KR"); 
		System.out.println(str8);*/
		
		/*String str5 = "ab홍길동";
		byte[] strBytes5= str5.getBytes("UTF-8"); 
		String str6 = new String(strBytes5, "UTF-8"); 
		System.out.println(str6);
		String str7 = new String(strBytes5, 2, 9,"UTF-8"); //인데스i부터 바이트의 길이를 읽음->문자셋에 따라 달라짐
		System.out.println(str7);*/
		
		String str5 = "ab홍길동";
		byte[] strBytes5= str5.getBytes("EUC-KR"); 
		String str6 = new String(strBytes5, "UTF-8"); 
		System.out.println(str6);
		
	}

}
