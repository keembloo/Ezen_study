/* 여기에 SQL문을 작성해서 DB 관리할 예정 */
# 한줄주석
# 확대 축소 ctrl + 마우스휠
-- 한줄주석
/* 여러줄 주석 */

/*
	데이터베이스 : 데이터[자료] , 베이스[모임]
		- 종류
			1. 계층형 데이터 베이스 : 트리형태
            2. 네트워크형 데이터 베이스 : 양방향 형태
            3. *관계형 데이터 베이스 : 행/열 구성된 테이블[표] 형태
            4. NoSQL 데이터 베이스 : Key-value
		
        - 용어
				DBA [ 데이터베이스 관리자 ]
					- 개발자
                DBMS [ 데이터베이스 관리 시스템 ]
					- MYSQL , ORACLE , MARIADB , SQLSERVER - 각 회사별 소프트웨어
                    - SQL [ 구조화된 질의/질문/요청 언어 ]
                DB [ 데이터베이스 ]
					- 실제 데이터 저장된 곳 = DB SERVER
                    - 메모리[ 16진수/기게어 ] : 개발자 직접적으로 관리 힘듬
                    
		- 관계
        
			DBA -------->  DB	 [ x ]
            개발자			기계어 

			DBA -------->	DBMS	---------> DB		[ o ]
            개발자			관리시스템				기계어
							MYSQL
                            ORACLE
                            
		- SQL	: DB 조작/관리/제어 할때 사용되는 언어/문법 (대소문자 구분x)
			- 1. DDL [ 데이터베이스 정의어 ] 
				- 1. create		: 데이터베이스 , 테이블(표) 생성
					- create database db명;
                    - create table 테이블명( 필드명 속성명 , 필드명 속성명 );
                    
                - 2. drop		: 데이터베이스 , 테이블(표) 삭제
					- drop database db명;
                    - drop database if exists db명;
                    - drop tabe table명; 
                    
                - 3. alter		: 테이블(표) 속성 수정
                - 4. truncate	: 테이블(표)내 데이터 초기화/삭제
                - 5. rename		: 테이블(표)의 이름 변경
                - 6. show		:
					- show databases;					: 데이터베이스 전체 목록보기
                    - show variables like 'datadir';	: 데이터베이스 저장소 로컬 경로 확인
				- 7. use
					- use db명	: 데이터베이스 사용
                    
            - 2. DML [ 데이터베이스 조작어 ]
				- 1. insert		: 테이블(표)에 레코드(행) 삽입
                - 2. select		: 테이블(표)에 레코드(행) 검색
					- select * from 테이블명 		: 테이블내 모든 필드의 레코드(행) 검색 [ * : 와일드카드(모든) ]
                    
                - 3. update		: 테이블(표)에 레코드(행) 수정
                - 4. delete		: 테이블(표)에 레코드(행) 삭제
            - 3. DCL [ 데이터베이스 제어어 ]
				- 1. grant		: 사용자 권한 부여
                - 2. revoke		: 사용자 권한 취소
            - 4. TCL [ 트랜잭션 제어어 ]
				- 1. commit		: !! 트랜잭션[명령어 단위] 완료
                - 2. rollback	: 트랜잭션[명령어 단위] 취소
        
        
        - 테이블 용어	 	/	 테이블 [ 표 ]
            
				속성		colum		열			필드
				 |		  |			|			 |
				학번		학생명	전화번호			주소
                1010	김규리	010-8888-8888	안양		가로 = 행 = row = 1번 레코드
                
			1. colum = 열 = 필드 = 속성 : 테이블[표]의 열
				학번필드 , 학생명필드 , 전화번호필드 , 주소필드
                
			2. 행 = row = 레코드 : 테이블[표]의 행
				1번레코드 , 2번레코드 , 3번레코드
                
			3. 행/열로 구성된 테이블(표)를 다른 테이블(표)와 연결/관계 = 관계형 데이터베이스
            
            
		- 데이터 필드 타입 [mysql 기준 *DBMS마다 조금씩 다름]
			1. 정수
				tinyint		[1바이트] : -128~127
                smallint	[2바이트] : +-3만정도
                mediumint	[3바이트] : +-8백만정도 
                int			[4바이트] : +-21억정도 
                bigint		[8바이트] : +-21억 이상
			2. 실수
				float		[4바이트] : 소수점 7자리
                double		[8바이트] : 소주점 15자리
			3. 문자
				char(문자길이) 		: ( 글자수 최소1~최대255 ) 고정길이 	char(3) -> 'ab' -> 3바이트	[ *저장할 데이터의 글자수가 정확히 정해져있는 경우 ]
                varchar(문자길이)		: ( 글자수 최소1~65535 ) 가변길이 	vachar(3) -> 'ab' -> 2바이트	[ *저장할 데이터의 글자수가 정ㅈ확하지 않을때 ]
			
            4. 대용량 문자
				text [ 최소1~최대65535 ]
                mediumtext [ 최소1~ 최대 16000000 ]
                longtext[ 4G ]		: 긴글 텍스트 
			5. 날짜
				date(날짜) : YYYY-MM-DD
                time(시간) : HH:MM:SS 
                datetime(날짜시간) : YYYY-MM-DD HH:MM:SS
			6. 논리
				boolean[1바이트]
            
            
		- 제약조건
			1. pk 	: primary key (pk필드명)
            2. fk	: foreign key (fk필드명) references pk테이블명(pk필드명) [선택 옵션]
        
*/
/*------------데이터베이스 만들기-------------*/
#예1  : 데이터베이스( 여러개의 테이블(표)들이 저장 할수있는 공간 ) 생성
create database sqldb1;
	# create 	: 생성한다.
    # database 	: 데이터베이스.
    # sqldb1 	: 이름정의 [ 아무거나 , 대소문자 구분x , 키워드x ]
	# ; 		: 명령어 끝마침.
		# 해당 명령어 줄에 커서를 위치한 상태에서 ctrl+엔터
        # 좌측 navigator 새로고침 눌러서 확인
create database sqldb2;
create database sqldb3;
create database sqldb4;
create database sqldb5;

#예2 : 데이터베이스 목록 보기
show databases;

#예3 : 데이터베이스 저장된 로컬[pc] 경로 확인
show variables like 'datadir';

#예4 : 데이터베이스 삭제
drop database sqldb1;
	# drop : 삭제한다.
    # database : 데이터베이스
    # sqldb1 : db명
drop database sqldb2;
drop database sqldb3;
drop database sqldb4;
drop database sqldb5;

#예5 : 만약에 데이터베이스 존재했을때 삭제 [ *만약에 데이터베이스가 없을때 삭제명령어 사용하면 오류 발생 ]
drop database if exists sqldb1;
	# if exists : 만약에 존재하면

#예6 : 여러개의 데이터베이스중 사용할 데이터베이스 선택 !!
use sqldb1;
use sqldb2;

#활용1 : 데이터베이스 새롭게 생성하세요.
# 1. 데이터베이스 존재하면 삭제처리
drop database if exists test1;

# 2. 데이터베이스 생성
create database test1;

# 3. 데이터베이스 사용준비
use test1;

/*------------테이블(표)만들기-------------*/
# 테이블(표)는 데이터베이스 안에 저장 [* 무슨 데이터베이스에서 테이블(표) 생성할건지 use DB명; ]
#예1 : 테이블 생성
use sqldb1; -- 테이블을 생성할 데이터베이스 선택
create table member( 아이디 text , 비밀번호 text );
	# create 	: 생성한다.
    # table 	: 테이블
    # member	: 이름 정의 [ 아무거나, 대소문자 구분x, 키워드x ]
    # ( ) ;		: 테이블 속성/열/필드 정의 구역
		# ( 필드명 타입 , 필드명 타입 , 필드명 타입 )	: 테이블(표) 제목/속성/열/필드 정의
#예2 : 테이블 확인
select * from member;
#예3 : 테이블 삭제
drop table member;


# 활용2 : 
/*
	문제1 : 
    1. 웹개발하는데 DB저장소 'sqldb1web' 이름으로 db생성
    2. 해당 db에 member 테이블 생성
		id ( 문자열 최대 20 )
        password( 문자열 최대 10 )
*/
# 1. 만약에 생성할 이름의 DB명이 존재하면 삭제
drop database if exists sqldb1web;
# 2. DB생성
create database sqldb1web;
# 3. DB 사용 선택
use sqldb1web;
# 4. 만약에 생성할 테이블의 이름이 member가 존재하면 삭제
drop table if exists member;
# 5. table 생성 ( 필드명 타입 , 필드명 타입 )
create table member (id varchar(20) , password varchar(10));
# 6. 테이블 생성후 확인
select * from member;

/*
	문제 2: 
        1. 웹개발하는데 DB저장소 'sqldb1web2' 이름으로 db생성
		2. 해당 db에 board 테이블 생성
			no 게시물 번호 ( 최대 21억정도 )
            title 게시물 제목 (문자열 최대 100)
            content 게시물 내용(문자열 최대 6만5천 이상 )
            view 게시물조회수(최대 21억정도 )
            datetime 게시물작성일( 날짜/시간 )

*/
# 1. 데이터베이스 생성
drop database if exists sqldb1web2;
create database sqldb1web2;
# 2. 테이블 생성
use sqldb1web2;
drop table if exists board;
create table board (no int , title varchar(100) , content longtext , view int , date datetime);
select * from board;

/*
	문제 3: 
        1. 웹개발하는데 DB저장소 'sqldb1web1' 이름으로 DB 선택
		2. 해당 db에 memberboard 테이블 기준으로 2개의 테이블 생성
			회원번호      ( 필드명 : mno      타입 : 최대 21억정도 )
			회원아이디      ( 필드명 : mid      타입 : 문자열 최대 20 )
			회원비밀번호    ( 필드명 : mpw      타입 : 문자열 최대 20 )
            
			게시물번호    ( 필드명 : bno        타입 : 최대 21억정도 )
			게시물제목      ( 필드명 : btitle    타입 : 문자열 최대 100 )   
			게시물내용    ( 필드명 : bcontent    타입 : 문자열 최대 6만5천 이상 )
			게시물조회수   ( 필드명 : bview       타입 : 최대 21억정도 )
			게시물작성일    ( 필드명 : bdate       타입 : 날짜/시간 )
			

*/
# 1. 데이터베이스 생성
drop database if exists sqldb2web1; # 만약에 동일한 db명이 존재했을때 생성불가능하기 때문에 만약에 존재하면 삭제
create database sqldb2web1; # 실행 : [명령어]; 마다 컨트롤+엔터 
# 2. 테이블 생성 
use sqldb2web1;
drop table if exists memberboard;
create table memberboard (mno int , mid varchar(20) , mpw varchar(20) , bno int , btitle varchar(100) , bcontent text , bview int , bdata datetime );
select * from memberboard;

# 테이블삭제 후 2개로 생성
use sqldb2web1;
drop table if exists memberboard;
create table member2 (mno int , mid varchar(20) , mpw varchar(20));
create table board2 (mno int , bno int , btitle varchar(100) , bcontent text , bview int , bdata datetime);
select * from member2;
select * from board2;

-- 예1 : 1:M 관계 / PK:FK관계

use sqldb2web1;
drop table if exists member2;
create table member2(mno int , mid varchar(20) , mpw varchar(20),
	primary key(mno)); -- 현재 테이블에서 mno 라는 필드를 식별키로 사용

drop table if exists board2;
create table board2(bno int , btitle varchar(100) , bcontent text , bview int , bdata datetime ,
	mno int , 	-- 1. FK필드 선언
	foreign key(mno) references member2(mno) -- 2. 현재 테이블에서 mno라는 필드를 외래키로 사용
		# foreign key(mno)	: mno라는 필드를 FK필드로 설정
        # references member2(mno)	: FK필드를 member2 테이블의 mno필드와 참조 [관계]
);

/*
   문제5 : 조건
      1) 키오스크 시스템 개발하는데 'sqldb2sys' 라는 이름으로 DB 생성 
        2) 카테고리(category) 와 제품(product) 테이블 2개를  선언 
        3)    카테고리 : 카테고리번호(cno) , 카테고리명(cname)  
         제품 : 제품번호(pno) , 제품명(pname) , 제품가격(pprice) 
         - 필드 타입은 적절한 타입으로 선언 
      4) 두 테이블간 관계 
         - pk필드는 새로 생성하지 않고 pk설정만 하고 fk필드는 선언후 관계 설정한다.
*/

drop database if exists sqldb2sys;
create database sqldb2sys;
use sqldb2sys;

drop table if exists category;
create table category(cno int , cname varchar(10) ,
	primary key(cno)
);

drop table if exists product;
create table product(pno int, pname varchar(30) , pprice int ,
	primary key(pno) , 
    cno int, -- FK 필드로 사용할 필드 선언 [연결할 PK필드명/타입과 동일하게 선언 ]
	foreign key(cno) references category(cno)
);

drop table if exists cart;
create table cart ( ono int , cdate datetime , ccount int ,
	# 주문번호, 주문상품, 주문날짜, 주문개수
	primary key (ono) ,
    cno int ,
    foreign key(cno) references category(cno) ,
	pno int,
	foreign key(pno) references product (pno)
);