package ch05.exam03;

import java.util.Scanner;

public class BoardExample {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		//String[][] boards = new String[100][];
		String[][] boards = null;
		boards = new String[100][];
		
		while(true){
			System.out.println("---------------------------------------------------------------");
			System.out.println("1. 목록 | 2. 글쓰기 | 3. 상세보기 | 4. 수정 | 5. 삭제 | 6. 종료");
			System.out.println("---------------------------------------------------------------");
			System.out.print("선택: ");
			String choice = scanner.nextLine();
			
			if(choice.equals("1")){ //목록
				System.out.println("***********************************************************");
				System.out.println("번호\t제목\t\t글쓴이\t조회수");
				System.out.println("***********************************************************");
				if(boards != null){
					for(String[] board : boards){
						if(board != null){
							System.out.println(board[0] + "\t"+board[1] + "\t\t" + board[3] + "\t" + board[4]);
						}
					}
				}
				
				
			} else if(choice.equals("2")){ //글쓰기
				int view = 0;
				System.out.print("제목입력: ");
				String title = scanner.nextLine();
				System.out.print("내용입력: ");
				String content = scanner.nextLine();
				System.out.print("글쓴이 입력: ");
				String writter = scanner.nextLine();
				for(int i=0; i<boards.length; i++){
					if(boards[i] != null){
						String[] board = { String.valueOf(i), title, content, writter, String.valueOf(view) };
						boards[i] = board;
						break;
					}
					
				}
				
			} else if(choice.equals("3")){ //상세보기
				System.out.print("선택한 글번호: ");
				int bno = Integer.parseInt(scanner.nextLine());
				System.out.println("************************************************************************");
				System.out.println("번호\t제목\t내용\t\t글쓴이\t조회수");
				System.out.println("************************************************************************");
				//for(String[] board : boards){
				String[] board = boards[bno];
				if(boards != null){
					int view = Integer.parseInt(board[bno]);
					++view;
					board[4] = String.valueOf(view);
					System.out.println(board[0] + "\t" + board[1] +"\t" + board[2] 
							+ "\t\t" + board[3] + "\t" + board[4]);
					}
				//}
			} else if(choice.equals("4")){ //수정
				int bno = Integer.parseInt(scanner.nextLine());
				for(String[] board : boards){
					if(bno == Integer.parseInt(board[bno])){
						System.out.print("제목입력: ");
						String title = scanner.nextLine();
						System.out.print("내용입력: ");
						String content = scanner.nextLine();
						for(int i=0; i<bno; i++){
								board[1] = title; 
								board[2] = content;
								boards[i] = board;
								break;
							
						}
					}
				}
				
				
			} else if(choice.equals("5")){ //삭제
				System.out.print("삭제할 글번호: ");
				int bNum = Integer.parseInt(scanner.nextLine());
				boards[bNum] = null;
			}
			else if(choice.equals("6")){
				break;
			}
		}
	}

}
