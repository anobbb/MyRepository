package ch11.exam04;

public class ExitExample {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager() {//익명자식객체생성
			@Override
			public void checkExit(int status) {
				if(status != 5){
					throw new SecurityException();
					//throw: 예외 발생시킴
				}
				System.out.println("나 죽네~");
			}
		});
		
		
		for(int i=0; i<10; i++){
			System.out.println(i);
			try{
				System.exit(i);
			} catch(SecurityException e){}
			
			
			/* System.out.println(i);
			 * if(i==5){
				//System.exit(0); //프로그램 실행 중지, 강제 종료
				System.exit(3); // 프로그램 완전히 종료
				//break;
				//return; //main method의 실행을 멈춰라. ->현재 실행중인 process 종료의 의미가 아님
				
			}*/
		}
		//System.out.println("내가 출력될까요?");
	}
	
	public static void method(int x){
		if(x == 5){
			return;
		}
		System.out.println(x);
	}

}
