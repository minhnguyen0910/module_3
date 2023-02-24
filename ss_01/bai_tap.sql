CREATE DATABASE bai_tap_ss1;
use bai_tap_ss1;
create database exercise;
drop database exercise;
create table classes(
id int primary key auto_increment,
name varchar(100)
);
create table teacher(
id int primary key auto_increment,
name varchar(100),
age int,
country varchar(50)
);
select * from classes;
select * from teacher;
insert into classes(name)
value('C1122G1'),
('C1222G1'),
('C1322G1'),
('C1422G1');
insert into teacher(name, age,country)
value('Hai',25,'Quang nam'),
('Trung',22,'Da nang'),
('Son',30,'Hue'),
('Quang',27,'Quang tri');
drop table teacher;
update teacher
set age=23
where id=2;
delete from teacher
where id<3;