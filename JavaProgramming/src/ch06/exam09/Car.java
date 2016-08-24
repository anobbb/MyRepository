package ch06.exam09;

public class Car {
	//Field
	int gas;
	
	//Constructor
	
	//Method
	void setGas(int gas){
		this.gas = gas;
	}
	
	boolean isLeftGas(){
		if(gas == 0){
			System.out.println("gas가 없습니다.");
			return false;
		} else{
			System.out.println("gas가 있습니다.");
			return true;
		}
	}
	
	void run(){
		while(true){
			if(gas>0){
				System.out.println("달립니다.(gas 잔량: " + gas + ")");
				gas -= 1; // gas--;
			} else{
				System.out.println("멈춥니다.(gas 잔량: " + gas + ")ㄴ");
				//break; : while문 밖으로만 나가게 돼서 while 밖의 코드가 있으면 실행
				return; //void method에서 값 없이 return 하면 method 종료, while 밖의 코드도 실행 안 됨.
			}
		}
				
	}
	
	

}
