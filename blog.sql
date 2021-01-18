create database blog;
use blog;

create table accounts (
        accounts_id bigint not null auto_increment,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        primary key (accounts_id),
        unique(email)
    );

 create table role (
       role_id bigint not null auto_increment,
        role varchar(255),
        primary key (role_id)
    );
 --
create table accounts_roles (
       accounts_id bigint not null,
        role_id bigint not null
    );

create table category (
       category_id bigint not null auto_increment,
        category varchar(255) not null,
        post_id bigint not null,
        primary key (category_id)
    );

create table comment (
       comment_id bigint not null,
        body TEXT,
        create_date timestamp not null,
        accounts_id bigint not null,
        post_id bigint not null,
        primary key (comment_id)
    );

create table post (
       post_id bigint not null auto_increment,
        created_at date,
        intro varchar(1000) not null,
        title varchar(1000) not null,
        accounts_id bigint not null,
        primary key (post_id)
    );

 alter table accounts_roles
       add constraint FKocid74jdgib9xk7u5tdmqxmff
       foreign key (role_id)
       references role(role_id);

alter table accounts_roles
       add constraint FKdkp74nwsrtw0p54ebqbxw2fkn
       foreign key (accounts_id)
       references accounts(accounts_id);

alter table category
       add constraint FKopeo59t1mr1euhddriighg7ir
       foreign key (post_id)
       references post(post_id);

alter table comment
       add constraint FKa7pw8ftnoftr5sragk0vca5s5
       foreign key (accounts_id)
       references accounts(accounts_id);

 alter table comment
       add constraint FKs1slvnkuemjsq2kj4h3vhx7i1
       foreign key (post_id)
       references post(post_id);

alter table post
       add constraint FK5843w8217vmjooov25whd3100
       foreign key (accounts_id)
       references accounts(accounts_id);


-- Users
-- password in plaintext: "password"
INSERT INTO ACCOUNTS ( password, email,  first_name, last_name)
VALUES
  ( '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'user@mail.com',  'Name', 'Surname');
-- password in plaintext: "password"
INSERT INTO ACCOUNTS ( password, email,  first_name, last_name)
VALUES
  ( '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'johndoe@gmail.com',  'John', 'Doe');
-- password in plaintext: "password"
INSERT INTO ACCOUNTS ( password, email,  first_name, last_name)
VALUES ( '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'ana@mail.com', 'Ana', 'Surname');

-- Roles
INSERT INTO ROLE (role_id, role)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE (role_id, role)
VALUES (2, 'ROLE_USER');

-- Accounts Roles
INSERT INTO ACCOUNTS_ROLES (accounts_id, role_id)
VALUES (1, 1);
INSERT INTO ACCOUNTS_ROLES (accounts_id, role_id)
VALUES (1, 2);
INSERT INTO ACCOUNTS_ROLES (accounts_id, role_id)
VALUES (2, 2);
INSERT INTO ACCOUNTS_ROLES (accounts_id, role_id)
VALUES (3, 2);

-- Posts
INSERT INTO POST (post_id, accounts_id, title, intro, created_at )
VALUES (1, 1, 'Title 1',
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
       now());
INSERT INTO POST (post_id, accounts_id, title, intro, created_at)
VALUES (2, 1, 'Title 2',
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
         now());
INSERT INTO POST (post_id, accounts_id, title, intro, created_at)
VALUES (3, 1, 'Title 3',
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
         now());
INSERT INTO POST (post_id, accounts_id, title, intro, created_at)
VALUES (4, 1, 'Title 4',
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
         now());
INSERT INTO POST (post_id, accounts_id, title, intro, created_at)
VALUES (5, 1, 'Title 5',
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
 now());
INSERT INTO POST (post_id, accounts_id, title, intro, created_at)
VALUES (6, 1, 'Title 6',
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
         now());
INSERT INTO POST (post_id, accounts_id, title, intro, created_at)
VALUES (7, 2, 'Title 7',
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
         now());
INSERT INTO POST (post_id, accounts_id, title, intro, created_at)
VALUES (8, 2, 'Title 8',
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
        now());
INSERT INTO POST (post_id, accounts_id, title, intro, created_at)
VALUES (9, 2, 'Title 9',
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
         now());
INSERT INTO POST (post_id, accounts_id, title, intro, created_at)
VALUES (10, 2, 'Title 10',
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
        now());
INSERT INTO POST (post_id, accounts_id, title, intro, created_at)
VALUES (11, 3, 'Title 11',
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
        now());
INSERT INTO POST (post_id, accounts_id, title, intro, created_at)
VALUES (12, 3, 'Title 12',
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
        now());

-- Comments
INSERT INTO COMMENT (comment_id, post_id, accounts_id, body, create_date)
VALUES (1,1, 1,
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
        now());
INSERT INTO COMMENT (comment_id,post_id, accounts_id, body, create_date)
VALUES (2,1, 2,
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
        now());
INSERT INTO COMMENT (comment_id,post_id, accounts_id, body, create_date)
VALUES (3,1, 3,
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
       CURRENT_TIMESTAMP());
INSERT INTO COMMENT (comment_id, post_id, accounts_id, body, create_date)
VALUES (4,6, 1,
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
        CURRENT_TIMESTAMP());
INSERT INTO COMMENT (comment_id,post_id, accounts_id, body, create_date)
VALUES (5,6, 2,
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
        CURRENT_TIMESTAMP());
INSERT INTO COMMENT (comment_id,post_id, accounts_id, body, create_date)
VALUES (6,6, 3,
'"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."',
        CURRENT_TIMESTAMP());

-- CATEGORY
INSERT INTO  CATEGORY(category_id, category, post_id)
VALUES(1,'SPRINGBOOT', 1);
INSERT INTO  CATEGORY(category_id, category, post_id)
VALUES(2,'JAPANESES', 2);