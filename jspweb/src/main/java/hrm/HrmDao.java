package hrm;

import java.util.ArrayList;

import model.dao.MemberDao;
import model.dto.MemberDto;

public class HrmDao extends Dao {
	// 싱글톤 객체
	private static HrmDao hrmDao = new HrmDao();
	public static HrmDao getInstence() {return hrmDao;}
	private HrmDao() {}
	
	
	// 1. 회원가입
	public boolean signup(HrmDto hrmDto) {
		try {
			String sql ="insert into hrm (himg , hname, hphone, hlevel , hdate) values( ? , ? , ? , ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setString(1, hrmDto.getHimg());
			ps.setString(2, hrmDto.getHname());
			ps.setString(3, hrmDto.getHphone());
			ps.setString(4, hrmDto.getHlevel());
			ps.setString(5, hrmDto.getHdate());
	
			int row = ps.executeUpdate();
			if( row == 1) return true;
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	// 2. 출력하기
	public ArrayList<HrmDto> view() {
		ArrayList<HrmDto> list = new ArrayList<>();
		try {
			String sql ="select * from hrm order by hno desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				HrmDto hrmDto = new HrmDto(
						rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4) , rs.getString(5) , rs.getString(6));
				list.add(hrmDto);
			} System.out.println(list);
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	
}

