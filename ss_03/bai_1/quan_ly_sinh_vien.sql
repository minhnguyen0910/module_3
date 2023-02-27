create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table my_class(
class_id int primary key auto_increment,
class_name varchar(50) not null,
class_date date not null,
class_status int);
create table students(
student_id int primary key auto_increment,
student_name varchar(50) not null,
address varchar(50),
phone varchar(11),
student_status int,
class_id int not null,
foreign key(class_id) references  lop_hoc(class_id)
);
create table subjects(
sub_id int primary key auto_increment,
sub_name varchar(50),
credit tinyint not null default 1,
statuss bit default 1
);
create table mark(
mark_id int primary key not null auto_increment,
sub_id int not null,
student_id int not null,
mark float default 0,
exam_time tinyint default 1,

unique(sub_id,student_id),
foreign key(sub_id) references subjects(sub_id),
foreign key(student_id) references students(student_id)
);
insert into ma_class
value(1,'A1','2008-12-20',1),
(2,'A2','2008-12-22',1),
(3,'A2',current_date(),1);
insert into students(student_name,address,phone,student_status,class_id)
value('Hung','Ha Noi','0912113113',1,1),
('Hoa','Hai Phong','',1,1),
('Manh','Hai Phong','011234323',1,1);
insert into subjects
value(1,'CF',5,1),
(2,'C',6,1),
(3,'HDJ',5,1),
(4,'RDBMS',10,1);
insert into mark(sub_id,student_id,mark,exam_time)
value(1,1,8,1),
(1,2,10,2),
(2,1,12,1);
select * from mark;
select * from students
where student_name like 'h%';
select * from my_class
where class_date like '%-12-%';
select * from subjects
where credit between 3 and 5;
update students
set class_id=2 where student_name='Hung'; 
select student_name,sub_name,mark
from mark
inner join students on mark.student_id=students.student_id
inner join subjects on mark.sub_id=subjects.sub_id
order by mark;