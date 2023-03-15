create database user_manage;
-- drop database user_manage; 
use user_manage;
create table is_user(
user_id int primary key auto_increment,
user_name varchar(50),
user_country varchar(50)
);
insert into is_user(user_name, user_country)
value("Minh",'Viet Nam'),
('Quoc Anh','Lao'),
('Minh Lanh','Campuchia');



