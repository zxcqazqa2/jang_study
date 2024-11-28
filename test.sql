select *from tbl_member;
select *from tbl_board;
select *from tbl_reply;
select *from tbl_cate;

insert into tbl_cate(id, name) values(1,"notice");
insert into tbl_cate(id, name) values(2,"free");

select * from tbl_board where cate_id=1;
select * from tbl_board where cate_id=2;


delete from tbl_board;




commit;

drop table tbl_reply;
drop table tbl_board;
drop table tbl_cate;
drop table tbl_member;
