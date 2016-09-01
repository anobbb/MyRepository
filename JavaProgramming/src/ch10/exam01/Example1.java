package ch10.exam01;

import java.util.Scanner;

public class Example1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("입력: ");
				String data = scanner.nextLine();
				int value = Integer.parseInt(data);
				System.out.println(value);
			} catch (Exception e) {
				System.out.println("숫자가 아닌 것 같습니다.");
			} finally{
				System.out.println("무조건 실행");
			}
		}
	}

}
