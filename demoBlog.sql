create database demoBlog;
use demoBlog;

create table category (
       category_id bigint not null auto_increment primary key,
        category varchar(255) not null,
        post_id bigint not null
    );
    
    create table comment (
       comment_id bigint not null auto_increment primary key,
        body TEXT,
        create_at timestamp not null,
        post_id bigint not null,
        user_id bigint not null
    );
     create table post (
       post_id bigint not null auto_increment primary key,
       title varchar(255) not null,
        intro varchar(255),
        slug varchar(255),
        name varchar(255),
        create_date timestamp not null,
        user_id bigint not null
    );

    create table role (
       role_id bigint not null auto_increment primary key,
	   role varchar(255)
    );

    create table user (
       user_id bigint not null auto_increment primary key,
        status boolean not null,
        email varchar(255) not null,
        username varchar(255) not null,
        password varchar(255) not null
    );

    create table user_role (
       user_id bigint not null,
        role_id bigint not null
    );

    create table tag (
       tag_id bigint not null auto_increment primary key,
	   name_tag varchar(255),
	   post_id bigint not null
    );

    alter table role add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role);
    alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);
    alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username);

    alter table category
       add constraint FKopeo59t1mr1euhddriighg7ir
       foreign key (post_id)
       references post(post_id);

	alter table comment
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1
       foreign key (post_id)
       references post(post_id);

	alter table tag
       add foreign key (post_id)
       references post(post_id);

	alter table comment
       add constraint FK8kcum44fvpupyw6f5baccx25c
       foreign key (user_id)
       references user(user_id);

	alter table post
       add constraint FK72mt33dhhs48hf9gcqrq4fxte
       foreign key (user_id)
       references user(user_id);

	alter table user_role
       add constraint FKa68196081fvovjhkek5m97n3y
       foreign key (role_id)
       references role(role_id);

	 alter table user_role
       add constraint FK859n2jvi8ivhui0rl0esws6o
       foreign key (user_id)
       references user(user_id);

-- USER
INSERT INTO USER ( email, password, username, status)
VALUES ("admin@gmail.com", "admin", "admin", true);
INSERT INTO USER ( email, password, username, status)
VALUES ("user@gmail.com", "user", "user", true);

-- ROLE
INSERT INTO ROLE ( role)
VALUES ( 'ROLE_ADMIN');
INSERT INTO ROLE ( role)
VALUES ( 'ROLE_USER');

-- User Roles
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id)
VALUES (2, 2);

-- Posts
INSERT INTO POST (user_id, title,name, intro, slug, create_date)
VALUES ( 1, 'Ngữ pháp Mimi kara N3 Unit1','Mini_N3_Unit1', 'Dịch theo sách Mini kara ngữ pháp N3',"slug",now());
-- Posts
INSERT INTO POST (user_id, title,name, intro, slug, create_date)
VALUES ( 1, 'Ngữ pháp Mimi kara N3 Unit1','Mini_N3_Unit1', 'Dịch theo sách Mini kara ngữ pháp N3',"slug",now());
-- Posts
INSERT INTO POST (user_id, title,name, intro, slug, create_date)
VALUES ( 2, 'Ngữ pháp Mimi kara N3 Unit1','Mini_N3_Unit1', 'Dịch theo sách Mini kara ngữ pháp N3',"slug",now());
-- Posts
INSERT INTO POST (user_id, title,name, intro, slug, create_date)
VALUES ( 2, 'Ngữ pháp Mimi kara N3 Unit1','Mini_N3_Unit1', 'Dịch theo sách Mini kara ngữ pháp N3',"slug",now());

-- CATEGORY
INSERT INTO  CATEGORY(post_id, category)
VALUES(1,'JAPANESES 1');
-- CATEGORY
INSERT INTO  CATEGORY(post_id, category)
VALUES(2,'JAPANESES 2');
-- CATEGORY
INSERT INTO  CATEGORY(post_id, category)
VALUES(3,'JAPANESES 3');
-- CATEGORY
INSERT INTO  CATEGORY(post_id, category)
VALUES(4,'JAPANESES 4');

-- TAG
INSERT INTO  TAG (post_id, name_tag)
VALUES(1,'ngữ pháp');
INSERT INTO  TAG (post_id, name_tag)
VALUES(2,'ngữ pháp');
INSERT INTO  TAG (post_id, name_tag)
VALUES(3,'ngữ pháp');
INSERT INTO  TAG (post_id, name_tag)
VALUES(4,'ngữ pháp');

-- Comment
INSERT INTO COMMENT(post_id, user_id, body, create_at)
VALUES(1,1,"Comment1", now());
INSERT INTO COMMENT(post_id, user_id, body, create_at)
VALUES(1,2,"Comment1", now());
INSERT INTO COMMENT(post_id, user_id, body, create_at)
VALUES(2,1,"Comment1", now());
INSERT INTO COMMENT(post_id, user_id, body, create_at)
VALUES(2,2,"Comment1", now());
       
       