package accountbook;

public class AccountbookDto {
	// 필드
	private int ano;
	private String acontent;
	private int aprice;
	private String adate;

	
	// 생성자
	public AccountbookDto() {}

 
	public AccountbookDto(int ano, String acontent, int aprice, String adate) {
		super();
		this.ano = ano;
		this.acontent = acontent;
		this.aprice = aprice;
		this.adate = adate;
	}

	// 등록하기위한 생성자 추가
	public AccountbookDto(String acontent, int aprice, String adate) {
		super();
		this.acontent = acontent;
		this.aprice = aprice;
		this.adate = adate;
	}
	
	// 메소드
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}


	public String getAcontent() {
		return acontent;
	}


	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}


	public int getAprice() {
		return aprice;
	}


	public void setAprice(int aprice) {
		this.aprice = aprice;
	}


	public String getAdate() {
		return adate;
	}


	public void setAdate(String adate) {
		this.adate = adate;
	}


	@Override
	public String toString() {
		return "AccountbookDto [ano=" + ano + ", acontent=" + acontent + ", aprice=" + aprice + ", adate=" + adate
				+ "]";
	}

	
}
