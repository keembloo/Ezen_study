drop database if exists sqldb3web;
create database sqldb3web;
use sqldb3web;
# -------------- 예제 변경될때
drop table if exists member1;
#create table member1 (mno int ,  primary key(mno));						#예1)
#create table member1 (mno int , mid varchar(10), primary key(mno));		#예2)
#create table member1 (mno int auto_increment , mid varchar(10), primary key(mno)); #예3)
#create table member1 (mno int auto_increment , mid varchar(10) not null, memail varchar(20), primary key(mno)); #예4)
#create table member1 (mno int auto_increment , mid varchar(10) not null unique , memail varchar(20), primary key(mno)); #예5)
create table member1 (
	mno int auto_increment , 							-- 회원번호 [pk, 자동번호 부여]
    mid varchar(10) not null unique , 					-- 회원아이디 [공백x , 중복x]
    memail varchar(20) not null unique, 				-- 회원이메일 [공백x , 중복x]
    mpoint int not null default 0,						-- 회원포인트 [공백x , 기본값 0]			 -- 회원가입시 고객이 입력하는 사항x
    mdate datetime not null default now(),				-- 회원가입일 [공백x , 기본값 현재날짜/시간] 	 -- 회원가입시 고객이 입력하는 사항x
    mreceive boolean not null default true,				-- 회원이메일수신여부 [공백x , 기본값 true]
    mimg varchar(1000) not null default '기본프로필.jpg',	-- 회원프로필사진 [공백x , 기본값 '기본프로필']
    primary key(mno)									-- pk설정
    ); #예6)


select * from member1;	-- 확인용 반복

# 예1) 테이블에 레코드/행 추가하기
	# 1. insert into 테이블명 values(값1, 값2, 값3); 			# 모든필드에 값 추가할때
    # 2. insert into 테이블명(필드명1, 필드명2) values(값1, 값2); 	#특정 필드에 값 추가할때
insert into member1 values(1);		-- member1 테이블의 mno필드에 1추가

#예2) 
insert into member1 values (1,'유재석'); -- 직접 데이터 입력할경우 문자/날짜 입력시 ' ' 
insert into member1 values (1,'유재석'); -- mno가 pk필드이므로 중복을 방지해서 오류 발생

#예3) auto_increment : insert(삽입시) 해당 필드에 값 생략하면 자동번호가 삽입
insert into member1 values (1,'유재석');	 -- 가능
insert into member1 values ('유재석');	 -- 오류 : '유재석' 데이터를 어떤 필드에 넣을지 식별 불가능
insert into member1(mid)values('유재석');  -- 오류방안 : 특정필드에만 데이터를 삽입할경우 테이블명(필드명제시);

#예4) not null : 해당 필드에 값이 무조건 존재해야되는 경우에 사용 [ JS-JAVA-DB 안정성 보장 ]
insert into member1(mid, memail) values ('유재석','qwe@com');
insert into member1(mid) values ('유재석'); 		-- 삽입시 필드 생략하면 생략된 필드는 null(비어있음뜻) 대입
insert into member1(memail) values('qwe@com');	-- 오류 : mid필드는 not null 제약조건을 사용했으므로 무조건 값 대입

#예5) unique : 해당 필드 값의 중복 방지
insert into member1(mid) values('유재석');
insert into member1(mid) values('유재석');	-- 오류 : mid필드는 unique 제약조건을 사용했으므로 기존에 있는 값을 대입할수가 없다 [중복방지]

#예6) default : 해당 필드에 값 삽입시 생략할때 자동으로 들어가는 기본값 설정
insert into member1(mid , memail) values('유재석','qwe@com');
insert into member1(mid , memail , mpoint) values('강호동','asd@com', 1000);
insert into member1(mid, memail, mpoint , mdate) values ('신동엽' , 'zxc@com' , 1000 , '2023-08-03 12:10:10');
insert 
		into member1(mid , memail, mpoint , mdate , mreceive )
		values('하하','cvb@com',1000,'2023-08-03 12:10:10', false);
insert 
		into member1(mid , memail, mpoint , mdate , mreceive , mimg)
		values('서장훈','kdd@com',0,'2023-08-03 12:10:10', false, '증명사진.jpg');
insert 
		into member1(mid , memail, mimg)
		values('김희철', 'fde@com', '김희철증명사진.jpg');







