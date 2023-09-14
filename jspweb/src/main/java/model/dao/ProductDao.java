package model.dao;

import java.sql.Statement;

import model.dto.ProductDto;

public class ProductDao extends Dao {
	private static ProductDao productDao = new ProductDao();
	public static ProductDao getInstence() {return productDao;}
	private ProductDao() {}
	
	
	// 1. 제품 등록
	public boolean register(ProductDto dto ) {
		// 1-1 제품 등록
		try {
			String sql = "insert into product( pcno , pname , pcontent , pprice , plat , plng , mno  ) "
					+ "	values( ? , ? , ? , ? , ? , ? , ?  );";
			// * sql insert 후 자동생송된 pk번호를 반환하는 방법
				// .prepareStatement( sql , Statement.RETURN_GENERATED_KEYS ); : 생성된 식별키를 반환
				// ps.getGeneratedKeys(); 			: 식별키 반환하는 함수 
			ps = conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS ); 
			
			ps.setInt(1, dto.getPcno());
			ps.setString(2, dto.getPname());
			ps.setString(3, dto.getPcontent());
			ps.setInt(4, dto.getPprice());
			ps.setString(5, dto.getPlat());
			ps.setString(6, dto.getPlng());
			ps.setInt(7, dto.getMno());
			
			int count = ps.executeUpdate(); // 제품 등록
			rs = ps.getGeneratedKeys(); // 제품 등록시 생성된 식별키[pk] 반환해서 resultset[ps]에 대입
			rs.next(); // 반환된 식별키들 중에서 다음으로 이동 
						// resultset null --- next() --> 결과레코드1 --next() --> 결과레코드2
						// 반환된 결과레코드로 1번 이동 [ 하나의 제품 식별키 필요 ] 
			
			if (count == 1) { // 만약에 제품 등록 1개 했으면
				// 1-2 제품 등록후 생성된 제품pk를 가지고 [이미지 등록 ]
					// 1. dto에 저장된 이미지 개수만큼
						// Map<Integer , String> 	: map 객체명.keySet() : map객체내 모든키호출
						// Map<Integer , String> 	: map 객체명.values() : map객체내 모든값호출
				
						// ------- get(인덱스) : list컬렉션은 인덱스 사용
						// ------- get(키) : set컬렉션 map컬렉션은 인덱스가 없으므로 키 값으로 호출
				
						// ------- 
				for( String img : dto.getImgList().values() ) {
					sql = "insert into productimg( pimg , pno ) values ( ? , ? )";
					ps = conn.prepareStatement(sql);
					ps.setString(1, img );
					ps.setInt(2, rs.getInt(1)); // 위에서 insert된 제품번호
					ps.executeUpdate();
				}
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	// 2. 제품 전체 출력
	
	// 3. 제품 개별 조회
	
	// 4. 제품 수정
	
	// 5. 제품 삭제 
	
	
}
