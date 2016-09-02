package ch11.exam03;

import java.util.Calendar;

public class Date {
	@Override
	public String toString(){
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR); //YEAR <- 상수값
		int month = now.get(Calendar.MONTH)+ 1; //0~11 -> 1~11
		int day = now.get(Calendar.DAY_OF_MONTH); 
		return year + "-" + month + "-" + day;
	}
}
