package ch18.exam23.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ServerExample extends Application {
	ExecutorService executorService;
	ServerSocket serverSocket;
	List<Client> connections = new Vector<Client>();

	void startServer() {
		// 스레드풀 생성(최대 스레드 50개만 사용)
		executorService = Executors.newFixedThreadPool(50);

		// ServerSocket 생성(5001번 포트를 사용)
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("192.168.0.15", 5001)); // ip바뀌어도
																			// 자동으로
																			// 처리됨.
		} catch (Exception e) {// 이미 5001 포트를 사용하고 있을 경우
			// 서버가 닫혀있지 않다면 서버를 닫게 함
			if (!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}

		// 클라이언트 연결 수락 작업 생성과 작업큐에 넣기
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						displayText("[서버 시작]");
						btnStartStop.setText("stop");
					}
				});

				while (true) {
					try {
						// 클라이언트의 연결을 기다리고 수락하기
						Socket socket = serverSocket.accept();
						String message = "[연결 수락: " + socket.getInetAddress().getHostAddress() + ": "
								+ Thread.currentThread().getName() + "]";
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								displayText(message);
							}
						});

						// 통신 객체 Client 생성
						Client client = new Client(socket);

						// Client 관리
						connections.add(client);
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								displayText("[연결 개수: " + connections.size() + "]");
							}
						});
					} catch (Exception e) {
						if (!serverSocket.isClosed()) {
							stopServer();
						}
						break;
					}
				} // while
			}// run
		}; // Runnable
		executorService.submit(runnable);
	}

	void stopServer() {
		try {
			Iterator<Client> iterator = connections.iterator();
			while (iterator.hasNext()) { // set이나 list에서는 for문써서 바로 remove하면 안
											// 됨.
				Client client = iterator.next();
				client.socket.close();
				iterator.remove(); // connections에서 지워짐
			}

			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close(); // 포트번호와의 바인딩 풀기
			}
			if (executorService != null && !executorService.isShutdown()) {
				executorService.shutdown();// 스레드풀도 종료(작업 프로세스 종료)
			}
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					displayText("[서버 멈춤]");
					btnStartStop.setText("start");
				}
			});
		} catch (Exception e) {
		}
	}

	class Client {
		Socket socket;

		Client(Socket socket) {
			this.socket = socket;
			receive();
		}

		void receive() {
			// 클라이언트의 데이터를 받는 작업 생성 및 작업 큐에 넣기
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						while (true) { // 데이터를 계속 받기 위해 무한루프(클라이언트가 종료하기 전까지)
							InputStream is = socket.getInputStream();
							byte[] values = new byte[600]; // utf-8 기준 한글 100글자
							int byteNum = is.read(values); //종료시 정상, 비정상 모두 예외 발생(-1 or 물리적 에러)
							if (byteNum == -1) {
								throw new IOException();
							}
							String data = new String(values, 0, byteNum, "UTF-8");
							for (Client client : connections) {
								client.send(data); // 현재 연결된 모든 클라이언트들에게 데이터 전송
							}
						} // while
					} catch (Exception e) {
						try {
							// 연결이 끊어진 현재 클라이언트 제거 (중첩 클래스에서 바깥클래스.this),
							// (정상+비정상 종료 모두)
							// 그냥 this하면 runnable이 종료됨
							connections.remove(Client.this);
							String message = "[클라이언트 통신 안 됨: " + socket.getInetAddress().getHostAddress() + ": "
									+ Thread.currentThread().getName() + "]";
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									displayText(message);
								}
							});

							socket.close();
						} catch (IOException e1) {}
					}
				}
			};
			executorService.submit(runnable);
		}

		void send(String data) {
			//클라이언트로 데이터를 보내는 작업 생성생성 및 작업큐에 넣기
			Runnable runnable = new Runnable(){
				@Override
				public void run() {
					try{
						OutputStream os = socket.getOutputStream();
						byte[] values = data.getBytes("UTF-8");
						os.write(values);
						os.flush();
					} catch(Exception e){ //클라이언트가 없어서 write하지 못할 때		
						try {
							// 연결이 끊어진 현재 클라이언트 제거 (중첩 클래스에서 바깥클래스.this),
							// (정상+비정상 종료 모두)
							// 그냥 this하면 runnable이 종료됨
							connections.remove(Client.this);
							String message = "[클라이언트 통신 안 됨: " + socket.getInetAddress().getHostAddress() + ": "
									+ Thread.currentThread().getName() + "]";
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									displayText(message);
								}
							});
							socket.close();
						} catch (IOException e1) {}
					}
				}
			};
			executorService.submit(runnable);
		}
	}

	//////////////////////////////////////////////////////
	TextArea txtDisplay;
	Button btnStartStop;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);

		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
		root.setCenter(txtDisplay);

		btnStartStop = new Button("start");
		btnStartStop.setPrefHeight(30);
		btnStartStop.setMaxWidth(Double.MAX_VALUE);
		btnStartStop.setOnAction(e -> {
			if (btnStartStop.getText().equals("start")) {
				startServer();
			} else if (btnStartStop.getText().equals("stop")) {
				stopServer();
			}
		});
		root.setBottom(btnStartStop);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.setOnCloseRequest(event -> stopServer());
		primaryStage.show();
	}

	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
