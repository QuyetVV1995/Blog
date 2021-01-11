create database blog;
use blog;

create table post(
	id bigint not null primary key auto_increment,
    title varchar(300) not null,
    content text,
    create_at datetime default null
);

insert into post(title, content, create_at)
values ("test1", "content1", now());
insert into post(title, content, create_at)
values ("test2", "content2", now());
insert into post(title, content, create_at)
values ("test2", "content2", now());

alter table post add column intro varchar(255) after title;
insert into post(title,intro, content, create_at)
values ("test1","intro1", "content1", now());