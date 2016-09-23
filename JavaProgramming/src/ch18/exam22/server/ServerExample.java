package ch18.exam22.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExample {
	public static ServerSocket serverSocket;
	private static boolean stop;
	private static ExecutorService executorService;

	public static void main(String[] args) {
		System.out.println("서버 시작");
		try {
			// 스레드풀 생성
			executorService = Executors.newFixedThreadPool(50);

			// 서버의 어떤 IP라도 접근할 수 있도록 한 것
			// main thread가 실행
			serverSocket = new ServerSocket(5001);

			// 클라이언트의 연결을 수락하는 작업 생성
			Runnable runnable = new Runnable() { // 익명 객체 생성
				@Override
				public void run() { // 다른 thread가 실행
					waitAndAccept();
				}
			};

			// 작업을 스레드풀의 작업풀에 넣기
			executorService.submit(runnable);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("명령어 입력: ");
			String command = scanner.nextLine();
			if (command.equals("stop")) {
				stop = true; // 작업 스레드 중지(클라이언트의 연결 수락을 중지)
				try {
					serverSocket.close(); // 서버를 중지함
					executorService.shutdown();
				} catch (IOException e) {
				}
				System.out.println("서버 종료");
				System.exit(0); // 서버 process 종료 -> while문도 종료됨
			}
		} // while
	}// main

	private static void waitAndAccept() {
		// main은 객체없이 실행하므로 이 메소드도 static으로 만들어야 함

		try {
			while (!stop) {
				// 클라이언트의 연결을 수락하고 통신용 Socket을 생성
				// 클라이언트 연결
				Socket socket = serverSocket.accept();

				// 통신을 담당하는 객체(client 객체) 생성
				Client client = new Client(socket);
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // waitAndAccept()

	static class Client { // 정적 내부(중첩) 클래스
		Socket socket;

		public Client(Socket socket) {
			this.socket = socket;
			receive();
		}

		// blocking 여부를 main이 아닌 작업thread가 처리하게 함
		public void receive() {
			// 클라이언트의 데이터를 받고, 에코 보내기를 하는 작업 생성
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					// 연결 이후 클라이언트와 통신
					try {
						while (true) {
							// 클라이언트에서 보낸 데이터를 받기
							InputStream is = socket.getInputStream();
							byte[] receiveValues = new byte[1024];
							int byteNum = is.read(receiveValues); // blocking
							if (byteNum != -1) {
								String data = new String(receiveValues, 0, byteNum, "UTF-8");

								// 클라이언트로 에코 보내기
								OutputStream os = socket.getOutputStream();
								byte[] sendValues = data.getBytes("UTF-8");
								os.write(sendValues);
								os.flush();
							} else {
								break;
							}

						} // while
					} catch (IOException e) {
						System.err.println("클라이언트가 비정상 종료됨");
					}

					// 해당 클라이언트와의 연결을 끊음
					try {
						socket.close();
					} catch (Exception e) {
					}
				}// run
			}; // runnable
				// 작업을 스레드풀의 작업큐에 넣기
			executorService.submit(runnable);
		} // receive()
	}// client class
}// class
