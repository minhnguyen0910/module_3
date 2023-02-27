create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
c_id int primary key,
c_name varchar(50),
c_tuoi int
);
create table is_order(
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
od_qty int,
primary key(p_id,c_id),
foreign key (p_id) references product(p_id),
foreign key (c_id) references is_order(c_id)
);
insert into customer(c_id,c_name,c_tuoi)
value(1,'Minh Quan',10),(2,'Ngoc Oanh',20),(3,'Hong Ha',50);
insert into product(p_id,p_name,p_price)
value(1,'May Giat',3),(2,'Tu Lanh',5),(3,'Dieu Hoa',7),
(4,'Quat',1),(5,'Bep Dien',2);
insert into is_order(o_id,c_id,o_date,o_total_price)
value(1,1,'2006-03-21'),(2,2,'2006-03-23'),(3,1,2006-03-16);
insert into order_detail(p_id,c_id,od_qty)
value(1,1,'a'),(2,2,'b');
