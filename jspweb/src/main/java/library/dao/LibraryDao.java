package library.dao;

import java.util.ArrayList;
import java.util.List;

import library.dto.LibraryDto;

public class LibraryDao extends Dao{
	// 싱글톤
	private static LibraryDao libraryDao = new LibraryDao();
	public static LibraryDao getInstance() { return libraryDao; }
	private LibraryDao() {}
	
	
	public List<LibraryDto> seatPrint(){ // 좌석 출력 sql문
		
		try {
			List<LibraryDto> list = new ArrayList<>();
			String sql = "select * from seat";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				LibraryDto dto = new LibraryDto();
				dto.setSno(rs.getInt(1));
				dto.setState(rs.getInt(2));
				list.add(dto);
			}
			return list;
			
		}catch (Exception e) {
			System.out.println("좌석 출력 sql문 예외 : "+e);
			return null;
		}
	} // 좌석 출력 sql문 종료
	
	public boolean enterSeat(LibraryDto dto) { // 입실 sql문 
		if(insertUser(dto)) {
			try {
	            String sql = "update seat set sstate = ? where sno = ?";
	            
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, dto.getSno());
	            ps.setInt(2, dto.getSno());
            if(ps.executeUpdate()==1) {
               return true;
            }else {
               return false;
            }
            
         }catch (Exception e) {
            System.out.println("입실 sql문 예외 : "+e);
            return false;
         }
      }
      return false;
	} // 입실 sql문 종료
	
	public boolean insertUser(LibraryDto dto) { // 유저 정보 저장 sql문
		
		try {
			String sql = "insert into user(uname, uphone) values(?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getUname());
			ps.setString(2, dto.getUphone());
			return ps.executeUpdate() == 1;
			
			
		}catch (Exception e) {
			System.out.println("유저 저장 sql문 예외 : "+e);
			return false;
		}
		
		
		
	}// 유저 정보 저장 sql 종료
	
	
	public boolean exitSeat(LibraryDto dto) { // 퇴실 sql문
	      
	      try {
	         String sql = "update seat set sstate = 0 where sstate = (select uno from user where uphone = ?)";
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, dto.getUphone());
	         int row = ps.executeUpdate();
	         //System.out.println("row : "+row);
	         if(row==1) {
	        	 //System.out.println("daoif도나");
	            return true;
	         }else {
	            return false;
	         }
	         
	      }catch (Exception e) {
	         System.out.println("퇴실 sql문 예외 : "+e);
	         return false;
	      }
	            
	   } // 퇴실 sql문 종료
	   
	   
	   
}
