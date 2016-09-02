package ch11.exam09;

public class NewInstanceExample {
	public static void main(String[] args) throws Exception{
		//Class clazz = Class.forName(args[0]); //method의 return type확인하기
		Class clazz = Class.forName("ch11.exam09."+ args[0]);
		//obj.execute(); <- 에러
		Object obj = clazz.newInstance();
		Action action = (Action)obj;
		//Action action = (Action)clazz.newInstance();
		action.execute();
	}
}
