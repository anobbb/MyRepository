package ch18.exam15;

import java.io.Serializable;

public class Member implements Serializable {
	
	private static final long serialVersionUID = -7614355132400340926L;
	private String mid;
	private String mname;
	private static String nation = "한국";
	private transient String mpassword;
	private int mage;
	private String job; //필드내용이 바뀌면 새로운 UID 생성 -> 매칭 실패 => Uid 명시적 선언하면 가능
	
	public Member(String mid, String mname, String mpassword, int mage) {
		this.mid = mid;
		this.mname = mname;
		this.mpassword = mpassword;
		this.mage = mage;
	}
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public static String getNation() {
		return nation;
	}

	public static void setNation(String nation) {
		Member.nation = nation;
	}

	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public int getMage() {
		return mage;
	}
	public void setMage(int mage) {
		this.mage = mage;
	}
	
	
}
