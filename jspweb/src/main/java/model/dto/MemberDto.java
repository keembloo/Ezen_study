package model.dto;

public class MemberDto {
	// 1. 필드
		// 1-1
	private int mno;
	private String mid;
	private String mpwd;
	private String memail;
	private String mimg;
	
	// 1-2 DB없는필드
	private String loginDatetime; // 로그인 시간	
	
	public String getLoginDatetime() {
		return loginDatetime;
	}

	public void setLoginDatetime(String loginDatetime) {
		this.loginDatetime = loginDatetime;
	}
	
	// 로그인 객체를 만들 생성자
	public MemberDto(String loginDatetime , int mno, String mid, String memail, String mimg) {
		super();
		this.loginDatetime = loginDatetime;
		this.mno = mno;
		this.mid = mid;
		this.memail = memail;
		this.mimg = mimg;
	}
	

	// 2. 생성자
	public MemberDto() {	}
	
	public MemberDto(int mno, String mid, String mpwd, String memail, String mimg) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}


	// 회원가입용 생성자

	public MemberDto(String mid, String mpwd, String memail, String mimg) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}
	
	
	
	// 3. 메소드

	public int getMno() {
		return mno;
	}




	public void setMno(int mno) {
		this.mno = mno;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getMpwd() {
		return mpwd;
	}


	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}


	public String getMemail() {
		return memail;
	}


	public void setMemail(String memail) {
		this.memail = memail;
	}


	public String getMimg() {
		return mimg;
	}


	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	
	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", memail=" + memail + ", mimg=" + mimg
				+ ", loginDatetime=" + loginDatetime + "]";
	}

}
