package ch06.exam11;

import java.util.Scanner;

public class ScoreManagement {
/*
 * 	int data = System.in.read(); //입력이 될 때까지 기다림, 한 바이트만 읽음
 *  System.out.println(data);
 */
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Student[] students = null;
		
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
				students = new Student[totalNum];
			} else if(choice.equals("2")){
				System.out.println("*********************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("*********************************************");
				for(int i=0; i<students.length; i++) {
					Student student = students[i];
					if(student != null) {
						System.out.println(student.no + "\t\t" + student.name + "\t\t" + student.score);
					}
				}
			} else if(choice.equals("3")){
				System.out.print("학생이름: ");
				String name = scanner.nextLine();
				System.out.print("점수: ");
				int score = Integer.parseInt(scanner.nextLine());
				for(int i=0; i<students.length; i++){
					if(students[i] == null){ //null인 곳을 찾아서 입력
						//students[i] = new Student(i, name, score);
						Student student = new Student(i, name, score);
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
				for(Student student : students){
					if(student != null){
						int score = student.score;
						if(max < score){
							max = score;
						}
					}
				}
				
				System.out.println("*********************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("*********************************************");
				
				for(Student student : students){
					if(student != null){
						int score = student.score;
						if(max == score){
							System.out.println(student.no + "\t\t" + student.name + "\t\t" + student.score);
						}
					}
				}
			
			} else if(choice.equals("6")){
				int sum = 0;
				int count = 0;
				for(Student student : students){
					if(student != null){
						count++;
						sum += student.score;
					}					
				}
				System.out.println("평균: " + (double)sum / count);
								
			} else if(choice.equals("7")){
				break;
			}
		}
	}

}
