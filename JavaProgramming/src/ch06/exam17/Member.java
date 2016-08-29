package ch06.exam17;

public class Member {
	private String mid;
	private String mname;
	private String mpassword;
	private int mage;
	private boolean madult;
	private double mheight;
	
	public Member(String mid){
		this.mid = mid;
	}
	//getter method
	public String getMid(){
		return mid;
	}
	//setter method
	public void setMheight(double mheight){
		if(mheight<0.0){
			mheight = 0.0;
		}
		this.mheight = mheight;
	}
}
