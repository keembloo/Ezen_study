# 도서관
use JSPWEB;

drop table if exists user;
create table user(
	uno int auto_increment,
    uname varchar(30) not null,
    uphone varchar(20) not null unique,
    primary key(uno)
    );

drop table if exists seat;
create table seat(
	sno int,
    sstate int default 0
);
#insert into accountbook (acontent , aprice , adate) values ( '닌텐도' , '132523' , '2023-08-23' );
select * from seat;
select * from user;

insert into seat (sno) values (1);
insert into seat (sno) values (2);
insert into seat (sno) values (3);
insert into seat (sno) values (4);
insert into seat (sno) values (5);
insert into seat (sno) values (6);
insert into seat (sno) values (7);
insert into seat (sno) values (8);
insert into user (uname , uphone) values ('김규리' , '010-1231-1231');
update seat set sstate = 1 where sno = 3;


select * from seat natunal join user where = ;