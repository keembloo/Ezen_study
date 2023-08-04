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
