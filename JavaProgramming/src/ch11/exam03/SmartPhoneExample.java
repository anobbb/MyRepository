package ch11.exam03;

public class SmartPhoneExample {
	public static void main(String[] args){
		SmartPhone myPhone = new SmartPhone("구글", "안드로이드");
		
		//매개값으로 객체를 주면 객체의 toString메소드를 호출해서 리턴값을 받아 출력
		String strObj = myPhone.toString();
		System.out.println(strObj);
		
		System.out.println(myPhone);
	}

}
