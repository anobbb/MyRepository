package ch13.exam08;

public class TextendsExample {
	public void method1(C1 <Integer> arg){} //가능
	public void method2(C1 <? extends Number> arg){} //이미 존재하는 C1을 Number로 제한
	public C1<? extends Number> method3(){return null;} //T를 Number로 제한
	//public C1<T extends Number> method3(){return null;} //기존의 C1이 있으므로 T로 새로 선언 불가능
}

class C1<T> {} //선언
//class C2<? extends Number> {} //?는 기존의 C2에서 선언된 타입이 있어야 가능, 기존의 C2가 없으므로 불가능 
class C2<T extends Number> {} //T를 새로 선언하면서 Number의 자식으로 제한
class C3{
	public <T> void method(T t){} //타입 파라메터를 T로 새로 선언
	public <T extends Number> void method(T t){} //타입 파라메터를 선언
	//public <? extends Number> void method(T t){} //기존의 제네릭 타입이 앞에 오지 않아서 불가능
}


