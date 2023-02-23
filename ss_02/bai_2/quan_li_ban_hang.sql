create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
c_id int primary key,
c_name varchar(50),
c_tuoi int
);
create table oder(
o_id int primary key,
c_id int,
o_date date,
o_total_price int,
foreign key (c_id) references customer(c_id)
);
create table product(
p_id int primary key,
p_name varchar(50),
p_price int
);
create table order_detail(
p_id int,
c_id int,
od_qty varchar(50),
primary key(p_id,c_id),
foreign key (p_id) references product(p_id),
foreign key (c_id) references oder(c_id)
);
select * from order_detail;
