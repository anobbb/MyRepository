package ch09.exam13;

public class ButtonExample {
	public static void main(String[] args){
		Button btnOk = new Button();
		
		int value = 10;
		
		//nested class, local class
		btnOk.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick() {
				// valule = 5; final 특성때문, read only
				System.out.println("음악을 " + value + "번 재생합니다.");
			}
		});
		
		btnOk.click();
	}
}


