package ch05.exam03;

import java.util.Scanner;

public class ScoreManagement {
/*
 * 	int data = System.in.read(); //입력이 될 때까지 기다림, 한 바이트만 읽음
 *  System.out.println(data);
 */
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String[][] students = null; // 참조변수가 객체를 참조하고있지 않다.
		
		while(true){
			System.out.println("-------------------------------------------------------------------------------");
			if(students == null){
				System.out.println("1. 총 학생 수 | 7. 종료 ");
			} else{
				System.out.println("1. 총 학생 수 | 2. 목록 | 3. 입력 | 4. 삭제 | 5. 최고 점수 | 6. 평균 | 7. 종료");
			}			
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print("선택: ");
			String choice = scanner.nextLine();
			if(choice.equals("1")){
				System.out.print("총 착생 수: ");
				int totalNum = Integer.parseInt(scanner.nextLine());
				students = new String[totalNum][];
			} else if(choice.equals("2")){
				System.out.println("*********************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("*********************************************");
				if(students != null){
					for(String[] student : students) { 
						/*for(int i=0; i<students.length; i++) {
							String[] student = students[i];
						}*/
						if(student != null) {
							System.out.println(student[0] + "\t\t" + student[1] + "\t\t" + student[2]);
						}
					}
				}
				
			} else if(choice.equals("3")){
				System.out.print("학생이름: ");
				String name = scanner.nextLine();
				System.out.print("점수: ");
				String score = scanner.nextLine();
				for(int i=0; i<students.length; i++){
					if(students[i] == null){
						String[] student = { String.valueOf(i), name, score };
						students[i] = student;
						break;
					}
				}
			} else if(choice.equals("4")){
				System.out.print("삭제할 학번: ");
				int sno = Integer.parseInt(scanner.nextLine());
				students[sno] = null;	
			} else if(choice.equals("5")){
				int max=0;
				for(String[] student : students){
					int score = Integer.parseInt(student[2]);
					if(student != null){
						if(max < score){
							max = score;
						}
					}
				}
				
				System.out.println("*********************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("*********************************************");
				
				for(String[] student : students){
					if(student != null){
						int score = Integer.parseInt(student[2]);
						if(max == score){
							System.out.println(student[0] + "\t\t" + student[1] + "\t\t" + student[2]);
						}
					}
				}
			
			} else if(choice.equals("6")){
				int sum=0;
				int count=0;
				for(String[] student : students){
					if(student != null){
						count++;
						sum += Integer.parseInt(student[2]);
					}					
				}
				System.out.println("평균: " + (double)sum / count);
								
			} else if(choice.equals("7")){
				break;
			}
		}
	}

}
