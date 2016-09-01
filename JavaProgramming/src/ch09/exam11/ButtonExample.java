package ch09.exam11;

public class ButtonExample {
	public static void main(String[] args){
		Button btnOk = new Button();
		btnOk.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick() {
				System.out.println("음악을 재생합니다.");
			}
			
		});
		
		Button btnCancel = new Button();
										//{}안에 선언된 객체의 생성자 O, 인터페이스의 생성자는 절대 없음.
		btnCancel.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick() {
				System.out.println("음악을 중지합니다.");
			}
		});
		
		btnOk.click();
		btnCancel.click();
	}
}


