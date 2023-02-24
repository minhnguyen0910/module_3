create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
c_id int primary key,
c_name varchar(50),
c_tuoi int
);
create table orders(
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
foreign key (c_id) references orders(c_id)
);
insert into customer(c_id,c_name,c_tuoi)
value(1,'Minh',24),(2,'Hai',30),(3,'Quoc',25),
(4,'Chinh',21);
insert into product(p_id,p_name,p_price)
value(1,'banh1',100),(2,'banh2',150),(3,'banh3',200);
insert into orders(o_id,c_id,o_date,o_total_price)
value(1,1,'2023-02-23',200),(2,2,'2023-02-23',300);
insert into order_detail(p_id,c_id,od_qty)
value(1,1,'a'),(2,2,'b');
select * from order_detail;
select *from product;
select*from customer;
select*from orders;