package library.dto;

public class LibraryDto {
	
	//필드
	// 1. 유저 필드
	private int uno;
	private String uname;
	private String uphone;
	// 2. 시트 필드
	private int sno;
	private int sstate;

	
	//생성자
	public LibraryDto () {}


	public LibraryDto(String uname, String uphone) {
		super();
		this.uname = uname;
		this.uphone = uphone;
	}


	public LibraryDto(int sno, int sstate) {
		super();
		this.sno = sno;
		this.sstate = sstate;
	}


	
	//메소드
	public int getUno() {
		return uno;
	}


	public void setUno(int uno) {
		this.uno = uno;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUphone() {
		return uphone;
	}


	public void setUphone(String uphone) {
		this.uphone = uphone;
	}


	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public int getState() {
		return sstate;
	}


	public void setState(int sstate) {
		this.sstate = sstate;
	}


	@Override
	public String toString() {
		return "LibraryDto [uno=" + uno + ", uname=" + uname + ", uphone=" + uphone + ", sno=" + sno + ", state="
				+ sstate + "]";
	}
	
}
