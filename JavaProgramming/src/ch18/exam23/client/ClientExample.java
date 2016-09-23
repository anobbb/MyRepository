package ch18.exam23.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientExample extends Application {
	Socket socket;

	void startClient() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					socket = new Socket();
					// 서버가 시작 안 했을 경우 예외 발생 가능
					socket.connect(new InetSocketAddress("192.168.0.48", 5001));
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							displayText("[연결 완료: " + socket.getRemoteSocketAddress() + "]");
							btnConn.setText("stop");
							btnSend.setDisable(false);
						}
					});
				} catch (Exception e) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							displayText("[서버 통신 안 됨]");
							if (socket != null && !socket.isClosed()) {
								stopClient();
							}
						}
					});
					return; // 더 이상 실행의 의미가 없으므로 return하고 끝냄
				} // catch
					// 성공적으로 실행됐을 경우 여기로~
				receive(); // 서버에서 올 데이터 받을 준비
			} // thread
		};
		thread.start();
	} // startClient()

	void stopClient() {
		if (socket != null && !socket.isClosed()) {
			try {
				socket.close();
			} catch (Exception e) {
			}

		} // if
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				displayText("[연결 끊음]");
				btnConn.setText("start");
				btnSend.setDisable(true);
			}
		});
	}// stopClient()

	void receive() { //startClient에서 thread생성하고 진행하므로 별도의 스레드 필요없음
		while (true) {
			try {
				InputStream is = socket.getInputStream();
				byte[] values = new byte[600];
				// 서버에서 언제 데이터 올 지 모르므로 예외 발생 가능
				int byteNum = is.read(values);
				if (byteNum == -1) {
					throw new IOException();
				}
				String data = new String(values, 0, byteNum, "UTF-8");
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						displayText("[받기 완료]" + data);
					}
				});
			} catch (Exception e) { // 서버 예외발생 시
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						displayText("[서버 통신 안 됨]");
					}
				});
				stopClient();
				break;
			} // catch
		} // while
	}// receive()

	void send(String data) { //수시로 호출되기 때문에 thread 필요
		Thread thread = new Thread(){
			@Override
			public void run() {
				try{
					OutputStream os = socket.getOutputStream();
					byte[] values = data.getBytes("UTF-8");
					os.write(values);
					os.flush();
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							displayText("[보내기 완료]");
						}
					});
				} catch(Exception e){ // write하기 전 서버가 죽으면
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							displayText("[서버 통신 안 됨]");
						}
					});					
					stopClient();
				}
			}
		};
		thread.start();
	}

	//////////////////////////////////////////////////////
	TextArea txtDisplay;
	TextField txtInput;
	Button btnConn, btnSend;

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);

		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
		root.setCenter(txtDisplay);

		BorderPane bottom = new BorderPane();
		txtInput = new TextField();
		txtInput.setPrefSize(60, 30);
		BorderPane.setMargin(txtInput, new Insets(0, 1, 1, 1));

		btnConn = new Button("start");
		btnConn.setPrefSize(60, 30);
		btnConn.setOnAction(e -> {
			if (btnConn.getText().equals("start")) {
				startClient();
			} else if (btnConn.getText().equals("stop")) {
				stopClient();
			}
		});

		btnSend = new Button("send");
		btnSend.setPrefSize(60, 30);
		btnSend.setDisable(true);
		btnSend.setOnAction(e -> send(txtInput.getText()));

		bottom.setCenter(txtInput);
		bottom.setLeft(btnConn);
		bottom.setRight(btnSend);
		root.setBottom(bottom);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Client");
		primaryStage.setOnCloseRequest(event -> stopClient());
		primaryStage.show();
	}

	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
