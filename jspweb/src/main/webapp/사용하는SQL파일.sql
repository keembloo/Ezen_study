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