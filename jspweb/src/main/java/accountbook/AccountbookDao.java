package accountbook;

import java.util.ArrayList;

import model.dao.Dao;

public class AccountbookDao extends Dao {
	//싱글톤객체
	private static AccountbookDao accountbookDao = new AccountbookDao();
	public static AccountbookDao getInstence() {return accountbookDao;}
	private AccountbookDao() {}
	
	// 1. 저장
	public boolean cwrite(AccountbookDto accountbookDto) {
		try {
			String sql ="insert into accountbook (acontent , aprice , adate) values ( ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1, accountbookDto.getAcontent());
			ps.setInt(2, accountbookDto.getAprice());
			ps.setString(3, accountbookDto.getAdate());
			int row = ps.executeUpdate();
			if (row ==1) return true;
		}catch (Exception e) {System.out.println(e);	}
		return false;
	}
	
	
	
	// 2. 호출
	public ArrayList<AccountbookDto> cread() {
		ArrayList<AccountbookDto> list = new ArrayList<>(); 
		try {
			String sql ="select * from accountbook order by adate desc , acontent asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()){
				AccountbookDto accountbookDto = new AccountbookDto(
						rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				list.add(accountbookDto);
				System.out.println(list);
			}
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	
	
	// 3. 수정
	
	// 4. 삭제 
	
}
