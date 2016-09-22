package ch18.exam16;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress myIA = InetAddress.getLocalHost();
		String myIp = myIA.getHostAddress();
		System.out.println("내 컴퓨터 IP: " + myIp);
		
		InetAddress[] naverIAs = InetAddress.getAllByName("www.naver.com");
		for(InetAddress ia : naverIAs){
			System.out.println("네이버 서버 IP: " + ia.getHostAddress());
		}
	}

}
