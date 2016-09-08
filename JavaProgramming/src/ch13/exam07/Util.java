package ch13.exam07;

public class Util {
	
	public static <T extends Number> int compare(T t1, T t2){
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		/*if(v1<v2) return -1;
		else if (v1 ==v2) return 0;
		else return 1;*/
		return Double.compare(v1, v2);
		//double이라는 정적 메소드 compare는 알아서 계산하여 반환해줌.(표준 API)
	}
	
	/*// 메소드 오버로딩
	public static int compare(int t1, int t2){}
	public static int compare(String t1, String t2){}
	public static int compare(Date t1, Date t2){}*/

}
