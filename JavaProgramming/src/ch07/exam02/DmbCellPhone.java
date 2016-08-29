package ch07.exam02;

public class DmbCellPhone extends CellPhone{

	//Field
	int channel;
	
	//Constructor
	DmbCellPhone(String model, String color, int channel){
		super(model, color); // 부모 생성자를 명확하게 호출
		//super()를 넣으면 부모 생성자에 명시적 생성자밖에 없어서 에러남
		/*this.model = model; //instance 메소드 또는 생성자 안에서만 쓸 수 있음.
		super.color = color; //super로 해결*/ 
		this.channel = channel;
	}
	
	//Method
	void turnOnDmb(){
		System.out.println("채널: " + channel + "번 DMB 방송 수신을 시작합니다.");
	}
	void changeChannelDmb(int channel){
		this.channel = channel;
		System.out.println("채널 " + channel + " 번으로 바꿉니다.");
	}
	void turnOffDmb(){
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
	
}
