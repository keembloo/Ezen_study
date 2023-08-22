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