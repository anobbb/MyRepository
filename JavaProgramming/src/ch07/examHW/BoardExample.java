package ch07.examHW;

import java.util.Scanner;

public class BoardExample {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Board[] boards = null;	
		
		while(true){
			//view = 0;
			System.out.println("---------------------------------------------------------------");
			if(boards == null){
				System.out.println(" 2. 글쓰기 | 6. 종료");
				boards = new Board[100];
			} else{
				System.out.println("1. 목록 | 2. 글쓰기 | 3. 상세보기 | 4. 수정 | 5. 삭제 | 6. 종료");
			}
			System.out.println("---------------------------------------------------------------");
			System.out.print("선택: ");
			String choice = scanner.nextLine();
			
			if(choice.equals("1")){ //목록
				System.out.println("***********************************************************");
				System.out.println("번호\t제목\t\t글쓴이\t조회수");
				System.out.println("***********************************************************");
					for(int i=0; i<boards.length; i++){
						Board board = boards[i];
						if(board != null){
							System.out.println(board.getBno() + "\t" + board.getBtitle() + "\t\t" 
						+ board.getBwriter() + "\t" + board.getBhitcount());
						}
					}
				
			} else if(choice.equals("2")){ //글쓰기
				System.out.print("제목입력: ");
				String btitle = (scanner.nextLine());
				System.out.print("내용입력: ");
				String bcontent = scanner.nextLine();
				System.out.print("글쓴이 입력: ");
				String bwriter = scanner.nextLine();
				int bhitcount = 0;
				for(int i=0; i<boards.length; i++){
					if(boards[i] == null){
						Board board = new Board(i, btitle, bcontent, bwriter, bhitcount);
						boards[i] = board;
						break;
					}
					
				}
				
			} else if(choice.equals("3")){ //상세보기
				System.out.print("선택한 글번호: ");
				String bChoice = scanner.nextLine();
				int bNum = Integer.parseInt(bChoice);
				System.out.println("************************************************************************");
				System.out.println("번호\t제목\t내용\t\t글쓴이\t조회수");
				System.out.println("************************************************************************");
				int bhitcount=0;
				for(int i=0; i<boards.length; i++){	
					Board board = boards[i];
					if(board != null){
						bhitcount = board.getBhitcount();
						if(bNum == board.getBno()){
							++bhitcount;
							board.setBhitcount(bhitcount);
							System.out.println( board.getBno() + "\t" + board.getBtitle() + "\t" + board.getBcontent() + "\t\t" 
									+ board.getBwriter() + "\t" + board.getBhitcount() );
						}
					}
				}
				
			} else if(choice.equals("4")){ //수정
				System.out.println("수정할 번호: ");
				int bNum = Integer.parseInt(scanner.nextLine());
				for(int i=0; i<boards.length; i++){
					Board board = boards[i];
					if(bNum == board.getBno()){
						System.out.print("제목입력: ");
						String btitle = scanner.nextLine();
						System.out.print("내용입력: ");
						String bcontent = scanner.nextLine();
							board.setBtitle(btitle); 
							board.setBcontent(bcontent);
							boards[bNum] = board;
							break;
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
