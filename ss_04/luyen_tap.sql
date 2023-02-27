use quan_ly_sinh_vien;
select * from subjects
where credit=(select max(credit) from subjects);

select * from subjects
inner join mark on mark.sub_id = subjects.sub_id
where mark = (select max(mark) from mark);


set sql_mode='';
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
select *, avg(mark.mark) as diem_tb
from students
inner join mark on mark.student_id = students.student_id
group by students.student_id
order by diem_tb;