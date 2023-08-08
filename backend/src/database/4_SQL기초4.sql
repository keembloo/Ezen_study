
# ---------------------------------------------------------------------#
# JDBC와 연결할 DB선언
drop database if exists sqldb4web;
create database sqldb4web;
# Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb4web" , "root" , "1234");

# 회원번호[자동] 아이디 비밀번호 이름 전화번호를 저장하는 member 테이블 생성
# member 테이블
use sqldb4web;
drop table if exists member;
create table member(
	mno int auto_increment unique not null,
    mid varchar(10) unique not null ,
    mpw varchar(20) not null ,
    mname varchar(10) not null ,
    mphone varchar(13) not null ,
    primary key (mno)
);
# 테이블과 비슷하게 memberDto 클래스 설계
select * from member;

# 1. 회원가입 [ 테이블에 레코드 삽입(insert) ]
insert into member ( mid , mpw , mname , mphone ) values ('qwer' , 'qwer' , 'qwer' , '010-2222-2222');

# 2. 로그인 [ 테이블에 값 검색(select) ]	-> 로그인 성공 : 검색레코드존재o[true] / 로그인 실패 : 검색레코드존재x[false]
select mid from member;					-- mid 필드의 레코드만 검색
select mid , mpw from member;	 		-- mid와 mpw 필드의 레코드만 검색
select mid , mpw , mname from member; 	-- mid와 mpw 와 mname 필드의 레코드만 검색
select * from member;	-- *[모든필드 뜻] 모든필드의 레코드 검색
# 1. 로그인할때 피룡한 필드 검색 [아이디 , 패스워드]
select mid , mpw from member;									#  select * from member;
# 2. 아이디와 패스워드가 일치한 레코드 검색
select mid , mpw from member where mid ='qwe'; 					#만약에 mid필드에 'qwe' 문자열에 있는 레코드 검색
select mid , mpw from member where mid ='qwer';					#만약에 mid필드에 'qwer' 문자열에 있는 레코드 검색 
#만약에 mid필드가 'qwer'이면서 mpw필드가 'qwer'인 레코드 검색
select mid , mpw from member where mid ='qwer' and mpw='qwer';
# 자바 문자열 변환
select * from member where mid =? and mpw = ?; 

/*
	1. 테이블의 필드 검색
		select 필드명 from 테이블명 					: 해당 필드의 레코드 검색
		select 필드명 , 필드명 , 필드명 from 테이블 	: 여러개 필드들의 레코드 검색
		select * from 테이블명						: 모든 필드[*]의 레코드 검색
    
	2. 필드에 조건 추가			[ where 조건절 (필드명 연산자 값)]
		select 필드명 from 테이블명 where 조건
        select 필드명 , 필드명 , 필드명 from 테이블명 where 조건
        select * from 테이블명 where 조건
        
*/

/*--------------------------------------------------------------------------*/
drop database if exists sqldb5web;
create database sqldb5web;
use sqldb5web;
drop table if exists table1;
create table table1( 데이터1 int , 데이터2 varchar(100));

# CRUD : 
# 1. insert [ C : create ] 회원가입 , 글쓰기 , 제품등록 , 주문 , 대여 등등
	# insert into 테이블명(필드명, 필드명) values (값1 , 값2)
insert into table1 (데이터1 , 데이터2 ) values (1, '유재석');		# 데이터1 필드에 '1' 데이터2 필드에 '유재석' 레코드 삽입
insert into table1 (데이터1 , 데이터2 ) values (2, '강호동');

# 2. select [ R : read ] 로그인 , 아이디찾기 , 비밀번호찾기 , 글목록 , 글조회 , 제품조회 , 주문현황 등등
	# select 필드명 from 테이블명
    # select 필드명 from 테이블명 where 조건절
select * from table1;						# 모든 레코드 검색	[ 모든필드 표시 ]
select * from table1 where 데이터2 = '강호동';	# 데이터2 필드의 값이 '강호동'인 레코드 검색 [ 모든필드 표시 ]

# 3. update [ U : update ] 
	# update 테이블명 set 필드명 = 수정값 , 필드명 = 수정값
    # update 테이블명 set 필드명 = 수정값, 필드명 = 수정값 where 조건절
update table1 set 데이터1 = 3; 							# 모든 레코드의 데이터2 필드의 값을 3으로 변경
update table1 set 데이터2 = 2 where 데이터2 = '유재석'; 		# 데이터2 필드의 값이 '유재석'이인 레코드의 데이터1 필드의 값을 2로 변경 

# 4. delete [ D : delete ]
	# delete from 테이블명
    # delete from 테이블명 where 조건절
delete from table1;							# 모든 레코드 삭제
delete from table1 where 데이터2 = '유재석';	# 데이터2 필드의 값이 '유재석'인 레코드 삭제


/*--------------------------------------------------------------------------*/
use sqldb4web;
/*1. 테이블의 모든 레코드검색 */
select * from member;
/*2. 회원가입 : mno 자동부여이므로 생략*/
insert into member ( mid , mpw , mname , mphone ) values( 'ezen02' , '1234' , '이젠' , '010-433-1234');
#insert into member ( mid , mpw , mname , mphone ) values( ? , ? , ? , ? );
/*3. 로그인 : 입력한 값이 존재하는지 검색 */
select * from member where mid = 'ezen02' and mpw = '1234'; # 로그인 성공 : 레코드 1개이상 검색되면
select * from member where mid = 'ezen02' and mpw = 'asdf'; # 로그인 실패 : 레코드 0개 검색
#select * from member where mid = ? and mpw = ?;

/*4. 아이디/전화번호 중복체크(유효성검사) : 입력한 값이 존재하는지 검색 */
select * from member where mid = 'ezen02'; 				# 조건에 충족한 레코드의 모든 필드 검색
#select * from member where mid = ?; 
select * from member where mphone = '010-433-1234';		# 조건에 충족한 레코드의 모든 필드 검색
# select * from member where mphone = ?';

/*5. 아이디찾기/비밀번호찾기 : 입력한 값의 레코드 검색 */
select mid from member where mname = '이젠' and mphone = '010-433-1234';		# 조건에 충족한 레코드의 아이디 필드만 검색
#select mid from member where mname = ? and mphone = ?;
select mpw from member where mid = 'ezen02' and mphone = '010-433-1234';	# 조건에 충족한 레코드의 비밀번호 필드만 검색
#select mpw from member where mid = ? and mphone = ?;

/*6. 회원수정 : 비밀번호 수정 : pk식별 조건 [pk필드는 수정하지 않음 - 권장] */
update member set mpw = '12345' where mno = 3;		#3번 회원인 레코드의 비밀번호 수정
#update member set mpw = ? where mno = ?;

/*6. 회원수정 : 이름, 전화번호 수정 : pk식별 조건 [pk필드는 수정하지 않음 - 권장 ] */
update member set mname ='ezen' , mphone = '010-1234-1234' where mno =3;	# 3회원인 레코드
#update member set mname =? , mphone = ?' where mno =?;

/*7. 회원탈퇴 : pk식별 조건 */
delete from member where mno =3; 	-- 3번 회원인 레코드 삭제
#delete from member where mno =?; 

