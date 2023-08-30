package hrm;

public class HrmDto {

	private int hno;
	private String himg;
	private String hname;
	private String hphone;
	private String hlevel;
	private String hdate;
	
	
	public HrmDto() {	}
	
	public HrmDto(int hno, String himg, String hname, String hphone, String hlevel, String hdate) {
		super();
		this.hno = hno;
		this.himg = himg;
		this.hname = hname;
		this.hphone = hphone;
		this.hlevel = hlevel;
		this.hdate = hdate;
	}
	
	// 직원등록하기위한 생성자

	public HrmDto(String himg, String hname, String hphone, String hlevel, String hdate) {
		super();
		this.himg = himg;
		this.hname = hname;
		this.hphone = hphone;
		this.hlevel = hlevel;
		this.hdate = hdate;
	}
	

	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public String getHimg() {
		return himg;
	}

	public void setHimg(String himg) {
		this.himg = himg;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	public String getHlevel() {
		return hlevel;
	}

	public void setHlevel(String hlevel) {
		this.hlevel = hlevel;
	}

	public String getHdate() {
		return hdate;
	}

	public void setHdate(String hdate) {
		this.hdate = hdate;
	}

	@Override
	public String toString() {
		return "HrmDto [hno=" + hno + ", himg=" + himg + ", hname=" + hname + ", hphone=" + hphone + ", hlevel="
				+ hlevel + ", hdate=" + hdate + "]";
	}
	
	
	
	
}
