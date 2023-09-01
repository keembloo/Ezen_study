
drop database if exists jspweb;
create database jspweb;
use jspweb;
drop table if exists visitlog;
create table visitlog(
	vno int auto_increment ,		-- 식별번호(방문록번호) , 자동번호 부여
    vwriter varchar(30) not null,	-- (방문록작성자명) , 공백불가능
    vpwd varchar(10) not null,		-- (방문록비밀번호) , 공백불가능
    vcontent text not null,			-- (방문록내용)	 , 공백불가능
    vdate datetime default now() ,	-- (방문록작성일/시간) , 생략시 자동날짜/시간 등록
    primary key (vno)
);

select * from visitlog;

#1. 저장 insert / 레코드 추가
insert into visitlog (vwriter , vpwd , vcontent) values ( '김규리' , '123' , '하이' );
-- insert into visitlog (vwriter , vpwd , vcontent) values ( '김규리' , '123' , '하이' );

#2. 호출 select / 모든 레코드 검색
select * from visitlog order by vdate desc;

#3. 수정 [ 조건필수 ]
update visitlog set vcontent ='내용수정함' where vno = 3; /* vno가 3이면 vcontent 필드의 값을 수정 */
update visitlog set vcontent ='내용수정함' where vno = 3 and vpwd = '1234'; /*vno가 3이면서 vpwd가 1234이면 vcontent 필드의 값을 수정*/
# update visitlog set vcontent =? where vno = ? and vpwd = ?;

#4. 삭제 [삭제할 식별자 필수 ]
delete from visitlog; /*모든 레코드 삭제 */
delete from visitlog where vno = 3; /* vno가 3이면 삭제 */
delete from visitlog where vno = 3 and vpwd = '1234'; /* vno가 3이면서 vpwd가 1234이면 레코드 삭제 */
# delete from visitlog where vno = ? and vpwd = ?;




# ----------------------가계부 ---------------------------
use jspweb;
drop table if exists accountbook;
create table accountbook(
	ano int auto_increment ,
    acontent varchar(20) not null ,
    aprice int not null ,
    adate varchar(10) not null ,
    primary key (ano)
);
select * from accountbook;

#저장
insert into accountbook (acontent , aprice , adate) values ( '닌텐도' , '132523' , '2023-08-23' );
#호출
select * from accountbook order by adate desc , acontent asc;
#수정
update accountbook set acontent = '술' , aprice = '1231' , adate = '2023-08-16' where ano = 5;
#삭제
delete from accountbook where ano = 1;


# ----------------------멤버 ---------------------------
use jspweb;
drop table if exists member;
create table member(
	mno int auto_increment ,
    mid varchar(10) not null unique,
    mpwd varchar(20) not null ,
    memail varchar(20) not null unique,
    mimg longtext , 
    primary key (mno)
);
select * from member;

# 1. 회원가입
insert into member( mid , mpwd , memail , mimg ) values('김규리' , 'aaa' , 'asd@asd.com' , 'default.jpg' );

# 2. 아이디중복검사 [ 특정 mid의 아이디로 검색했을때 존재하면 사용중인 아이디 , 없으면 사용중인 아이디 X ] 
select * from member where mid = 'asdf';
select mid from member where mid = 'asdf';

# 3. 로그인 [ 아이디와 비밀번호가 일치한 레코드 존재여부 ]
select * from member where mid = 'qwer' and mpwd ='qwer1'; # 레코드가 검색되면 로그인 성공 / 없으면 로그인 실패

# 4. 회원정보 호출 [ 아이디를 이용한 패스워드 제외하고 모든 회원정보 호출 ] 
select mno, mid , memail, mimg from member where mid = 'qwer';

# 5. 회원탈퇴 [ 누구(mno)를 탈퇴할건지 , 검증(탈퇴할 회원의 패스워드) ] 
delete from member where mno = 1 and mpwd = 'asdf1'; # 1번 회원의 패스워드가 'asdf1'이면 레코드삭제

# 6. 프로필 수정 [ 누구(mno)를 수정할건지 , 수정할 내용(사진명) ]
update member set mimg = 'asdf.jpg' where mno = 1; # 1번 회원의 이미지명 변경

# 6. 프로필 비밀번호 추가 수정
update member set mimg = 'asdf.jpg' , mpwd ='qwer2' where mno = 1 and mpwd='qwer1';

select * from member;

#------------------------ 회원제 게시판 --------------------------------------
use jspweb;
drop table if exists bcategory;
create table bcategory(
	bcno int auto_increment ,
    bcname varchar(30) not null,
    primary key (bcno)
);

insert into bcategory(bcname) values ('공지사항');
insert into bcategory(bcname) values ('자유게시판');
insert into bcategory(bcname) values ('노하우');
select * from bcategory;


drop table if exists board;
create table board(
	bno int auto_increment ,
    btitle varchar(20) not null ,
    bcontent longtext ,
    bfile longtext ,
    bdate datetime default now() ,
    bview int default 0 , 
    primary key (bno) ,
    mno int ,
    foreign key (mno) references member(mno) on delete cascade , 
    -- 회원탈퇴시 게시물도 같이 삭제 [ 제약조건 ]
    bcno int ,
    foreign key (bcno) references bcategory(bcno) on delete cascade on update cascade 
    -- 카테고리 삭제시 게시물 삭제 , 카테고리 번호 변경시 fk도 같이 변경
);

select * from board;
# 1. 글등록
insert into board( btitle , bcontent , bfile , mno , bcno) values ('sdfsdf' , 'sdfsdf' , 'sdfsdf' , 12 , 1);

# 2. 글출력 
select bno , btitle , mid , bdate , bview from member natural join board order by bno desc;
	# 게시물 테이블과 회원 테이블 조인[테이블합치기 / pk - fk ]
    # 게시물 테이블내 작성자번호와 회원테이블의 작성자번호와 같으면
select * from board b natural join member m ; 
select b.bno , b.btitle , b.bfile , b.bdate , b.bview from board b natural join member m ; 
select b.bno , b.btitle , b.bfile , b.bdate , b.bview , m.mid from board b natural join member m ; 
	#게시물테이블, 회원테이블, 게시물카테고리테이블
select * from board b natural join bcategory bc natural join member m; # 자연조인
	#게시물 테이블 모든 필드 , 회원테이블의 아이디/프로필 , 게시물카테고리테이블의 카테고리명
select b.bno , b.btitle , b.bcontent , b.bfile , b.bdate , b.bview , b.mno, b.bcno, m.mid , bc.bcname
	from board b
		natural join bcategory bc
        natural join member m;
        
select b.* , m.mid , m.mimg , bc.bcname 
   from board b 
      natural join bcategory bc 
      natural join member m 
   order by b.bdate desc; 



#------------------------과제3 : 인사관리 -------------------------------------
use jspweb;
drop table if exists hrm;
create table hrm(
	hno int auto_increment ,
    himg longtext ,
    hname varchar(10) not null,
    hphone varchar(13) not null unique ,
    hlevel varchar(10) not null ,
    hdate varchar(10) not null , 
    primary key (hno)
);

select * from hrm;
insert into hrm (himg , hname, hphone, hlevel , hdate) values( 'asdf' , 'asdf' , 'asdf', 'asdf' , 'asdf');
#insert into hrm (himg , hname, hphone, hlevel , hdate) values( ? , ? , ? , ? , ? );

select * from hrm order by hdate desc;
select * from hrm order by hno desc;


