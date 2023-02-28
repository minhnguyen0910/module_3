create database demo;
use demo;
create table products(
id int primary key,
product_code int,
product_name varchar(50),
product_price double,
product_amount int,
product_description varchar(100),
product_status bit
);

insert into products(id, product_code, product_name, product_price, product_amount, product_description, product_status)
value(1,1,'Lenovo',1000,20,'Máy đẹp, chạy êm, nhanh nóng', 1),
(2,2,'Dell',900,15,'Máy bền, dùng thuận tay,hơi nặng', 1),
(3,3,'Asus',1200,18,'Máy đẹp, chạy êm, chơi game mượt', 1),
(4,4,'Acer',1100,25,'Máy đẹp, chạy êm, mỏng nhẹ', 1),
(5,5,'Mac',2000,10,'Máy đẹp, chạy êm, mỏng nhẹ, chơi game mượt', 1);

create unique Index product_code_index on products(product_code);
create index product_name_price_index on products(product_name,product_price);

explain select *
from products
where product_code = 5;

explain select * 
from products
where product_name = 'Mac';

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
-- Tiến hành sửa đổi view
-- Tiến hành xoá view

create view infor_product as
select product_code,product_name,product_price,product_status
from products;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
-- Tạo store procedure thêm một sản phẩm mới
-- Tạo store procedure sửa thông tin sản phẩm theo id
-- Tạo store procedure xoá sản phẩm theo id

DELIMITER $$
create procedure information()
begin
select*from products;
end $$
DELIMITER ;
call information;

DELIMITER $$
create procedure add_product(in a int,b int, c varchar(50), d double, e int, f varchar(100), j bit)
begin
insert into products value(a,b,c,d,e,f,h);
end $$
DELIMITER ;

DELIMITER $$
create procedure update_product(in id int, product_name varchar(50))
begin
update products
set product_name=product_name
where id=id;
end $$
DELIMITER ;

DELIMITER $$
create procedure delete_product(in id int)
begin
delete from products
where id=id;
end $$
DELIMITER ;