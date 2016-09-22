package ch18.exam18.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class ClientExample {
	public static void main(String[] args){
		//소켓 생성
		Socket socket = new Socket();
		
		try {
			//연결 요청하기
			SocketAddress sa = new InetSocketAddress("192.168.0.15", 5001);
			socket.connect(sa);
			System.out.println("[서버와 연결됨]");
			
			//보낼 데이터를 키보드로부터 읽기
			Scanner scanner = new Scanner(System.in);
			System.out.print("보낼 데이터: ");
			String data = scanner.nextLine();
			
			//서버로 데이터를 보내기
			OutputStream os = socket.getOutputStream();
			PrintStream ps = new PrintStream(os);
			ps.println(data);
			ps.flush();
			
			//서버에서 보낸 데이터를 읽기
			InputStream is = socket.getInputStream();
			Reader reader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(reader);
			data = br.readLine();
			System.out.println(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		//서버의 연결을 끊음
		try {
			socket.close();
		} catch (IOException e) {}
	}
}
