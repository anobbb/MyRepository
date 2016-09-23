package ch18.exam20.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	public static ServerSocket serverSocket;
	private static boolean stop;

	public static void main(String[] args) {
		System.out.println("서버 시작");
		try {
			// 서버의 어떤 IP라도 접근할 수 있도록 한 것
			// main thread가 실행
			serverSocket = new ServerSocket(5001);

			Thread thread = new Thread() { // 익명 객체 생성
				@Override
				public void run() { // 다른 thread가 실행
					waitAndAccept();
				}
			};
			thread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("명령어 입력: ");
			String command = scanner.nextLine();		
			if(command.equals("stop")){
				stop = true; //작업 스레드 중지(클라이언트의 연결 수락을 중지)
				try {				
					serverSocket.close(); // 서버를 중지함
				} catch (IOException e) {
				}
				System.out.println("서버 종료");
				System.exit(0); //서버 process 종료 -> while문도 종료됨
			}	
		}//while			
	}//main

	private static void waitAndAccept() {
		// main은 객체없이 실행하므로 이 메소드도 static으로 만들어야 함

		try{
			while (!stop) {
				// 클라이언트의 연결을 수락하고 통신용 Socket을 생성
				Socket socket = serverSocket.accept();

				// 클라이언트에서 보낸 데이터를 받기
				InputStream is = socket.getInputStream();
				byte[] receiveValues = new byte[1024];
				int byteNum = is.read(receiveValues);
				String data = new String(receiveValues, 0, byteNum, "UTF-8");

				// 클라이언트로 에코 보내기
				OutputStream os = socket.getOutputStream();
				byte[] sendValues = data.getBytes("UTF-8");
				os.write(sendValues);
				os.flush();

				// 해당 클라이언트와의 연결을 끊음
				socket.close();
			} //while
		} catch(Exception e){
			e.printStackTrace();
		}
	} //waitAndAccept
}//class
