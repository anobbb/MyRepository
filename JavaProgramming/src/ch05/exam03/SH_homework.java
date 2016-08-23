package ch05.exam03;

import java.util.Scanner;

public class SH_homework {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] boards= new String[100][];
		int count=0;
		
		while(true){
		
			System.out.println("====================================================================");
			System.out.println("1.목록 | 2.글쓰기 | 3. 상세보기 | 4. 수정하기 | 5. 삭제하기 | 6.종료");
			System.out.println("====================================================================");
			System.out.print("선택 : ");
			
			String choice = scanner.nextLine();
		
			
			if(choice.equals("1")){
				System.out.println("***********************************************************************");
				System.out.println("게시물번호\t\t제목\t\t글쓴이\t\t조회수");
				System.out.println("***********************************************************************");
				if(boards != null){
					for(String[] board : boards){
						if(board != null){
							System.out.println(board[0] + "\t\t" + board[1] + "\t\t" + board[2]+ "\t\t" + board[4]);
						}
					}
				}
			}
			else if(choice.equals("2")){

				System.out.print("제목 : ");
				String name = scanner.nextLine();
				System.out.print("글쓴이 : ");
				String author = scanner.nextLine();
				System.out.print("내용 : ");
				String common = scanner.nextLine();
				for(int i = 0;i<boards.length;i++){
					if(boards[i]== null){
						String[] board = {String.valueOf(i),name,author,common,String.valueOf(count)};
						boards[i] = board;
						break; //가장 가까운 for문에 영향을 미친다.
					}
				}
			}
			else if(choice.equals("3")){
				System.out.print("상세히 볼 번호: ");
				int numSelect = Integer.parseInt(scanner.nextLine());
				System.out.println("글쓴이: " + boards[numSelect][1]); 
				System.out.println("제목: " + boards[numSelect][2]); 
				System.out.println("내용: " + boards[numSelect][3]); 
				System.out.println("조회수: " + boards[numSelect][4]); 
				count++;
				boards[numSelect][4] = String.valueOf(count);
			}
			else if(choice.equals("4")){					
					System.out.print("수정할 번호 : ");			
					int numModify = Integer.parseInt(scanner.nextLine());
					if(boards[numModify]!=null){
					System.out.print("제목 수정 : ");
					boards[numModify][1] = scanner.nextLine();
					System.out.print("글쓴이 수정 : ");
					boards[numModify][2] = scanner.nextLine();
					}
					else{
						System.out.println("수정할 번호가 없습니다!");
					}
			}			
			else if(choice.equals("5")){
				System.out.print("삭제할 번호 : ");
				int delete = Integer.parseInt(scanner.nextLine());
				if(boards[delete]!=null){
					boards[delete] = null;
				}
				else
					System.out.println("삭제할 번호가 없습니다!");
			}
			else if(choice.equals("6")){
				break;	
			}
		}

	}

}
