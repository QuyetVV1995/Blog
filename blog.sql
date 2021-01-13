create database blog;
use blog;

create table post(
	id bigint not null primary key auto_increment,
    title varchar(300) not null,
    intro varchar(255),
    content text,
    created_at datetime default null
);

insert into post(title, intro, content, created_at)
values ("test1","intro", "content1", now());
insert into post(title, intro, content, created_at)
values ("test2","intro", "content2", now());
insert into post(title, intro, content, created_at)
values ("test3","intro", "content3", now());
insert into post(title, intro, content, created_at)
values ("test4","intro", "content4", now());

create table accounts(
	id bigint primary key auto_increment,
	username varchar(255) not null,
    active bit not null,
    encryted_password varchar(255),
    user_role varchar(20) not null
);
insert into accounts (username, active, encryted_password, user_role)
values ('employee1', 1,
'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_EMPLOYEE');
 
insert into accounts (username, active, encryted_password, user_role)
values ('manager1', 1,
'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_MANAGER');

select * from post where title like '%test%';
select * from post where title like '%test%'  limit 0,1;

drop table accounts;

create table accounts(
id bigint not null primary key auto_increment,
email varchar(255) not null,
first_name varchar(255),
last_name varchar(255),
password varchar(255)
);
create table role(
id bigint not null primary key auto_increment,
name varchar(255)
);
create table accounts_roles(
id bigint not null primary key auto_increment,
account_id bigint not null,
role_id bigint not null
);

alter table accounts_roles add  foreign key(account_id) references accounts(id);
alter table accounts_roles add  foreign key(role_id) references role(id);
