package ch11.exam15;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now.toString()); //꼭 toString안해도 자동으로 호출되긴 함
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strDate = sdf.format(now);
		System.out.println(strDate);
		
		/*매개값없으면 현재 컴퓨터 시간 얻음, 추상클래스이므로 new Calendar로 접근 못함(생성자가 protected)
		상속만 가능 & 내부 메소드이용*/
		Calendar cal = Calendar.getInstance(); 
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) +1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int amPm = cal.get(Calendar.AM_PM);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("year: " + year);
		System.out.println("month: " + month);
		System.out.println("day: " + day);
		System.out.println("hour: " + hour);
		System.out.println("minute: " + minute);
		System.out.println("second: " + second);
		System.out.println("amPm: " + amPm);
		System.out.println("week: " + week);
	}

}
