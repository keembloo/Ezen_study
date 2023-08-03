drop database if exists portfolio;
create database portfolio;
use portfolio;

#직급 테이블
drop table if exists companyLevel;
create table companyLevel( clevel int , cname varchar(10) ,
	primary key (clevel) 
);

#회원 테이블
drop table if exists memberlist;
create table memberlist( mno int auto_increment, 
	mcategory varchar(10) not null, 
    mname varchar(10) not null, 
    mid varchar(10) not null unique, 
    mpw varchar(15) not null,
	primary key (mno) ,
    clevel int,
    foreign key (clevel) references companyLevel(clevel)
);

#제품 카테고리목록
drop table if exists category;
create table category (
	cno int auto_increment , 
    cname varchar(20) not null unique ,
    cprice int not null,
    primary key(cno) 
);

#제품 컬러
drop table if exists color;
create table color (
	colorno int auto_increment ,
    colorname varchar(10) not null unique ,
    primary key(colorno)
);

#제품 사이즈
drop table if exists size;
create table size (
	sno int auto_increment , 
    ssize varchar(15) not null unique,
    primary key(sno)
);

#재고 목록
drop table if exists stock;
create table stock (
	scode varchar(10) unique not null,
    scount int default 0 not null,
    primary key(scode),
    cno int , 
    foreign key(cno) references category(cno) ,
    colorno int , 
    foreign key(colorno) references color(colorno) ,
    sno int , 
    foreign key(sno) references size(sno)
);