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



