create table dept
(
	dept_no bigint auto_increment,
	dept_name varchar(100) null,
	db_source varchar(100) null,
	constraint dept_pk
	primary key (dept_no)
)
comment '部门表';