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
create table memberlist( mno int , mcategory varchar(10) , mname varchar(10) , mid varchar(10) , mpw varchar(15) ,
	primary key (mno) ,
    clevel int,
    foreign key (clevel) references companyLevel(clevel)
);

#제품 테이블
drop table if exists product;
create table product( pno int , pname varchar(10) , psize int , pcolor varchar(10) , pprice int , pcount int ,
	primary key (pno) ,
    mno int,
    foreign key (mno) references memberlist(mno)
);

#판매 테이블
drop table if exists sale;
create table sale ( sno int , sdate datetime ,
	primary key (sno) ,
    pno int,
    foreign key(pno) references product(pno)
);