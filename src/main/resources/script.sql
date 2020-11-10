CREATE TABLE "user"(
  id SERIAL primary key not null,
  first_name varchar(50) not null,
  last_name varchar(50) not null,
  password varchar(100) not null,
  email varchar(30) not null,
  created_at date not null ,
  role varchar(20) not null
);

CREATE TABLE comment(
  id SERIAL not null,
  message VARCHAR(2000) not null ,
  id_user int not null,
  approved VARCHAR(10) not null,
  created_at date not null,
  PRIMARY KEY (id,id_user),
  foreign key (id_user) references "user"(id)ON DELETE CASCADE ON UPDATE CASCADE
);


insert into "user"(first_name, last_name, password, email, created_at, role)
VALUES ('Maks','Titok','qwerty007','maks.titok@gmail.com','09-11-2020','ADMIN');

insert into "user"(first_name, last_name, password, email, created_at, role)
VALUES ('Misha','Pashkevich','newQwerty','miha2001@gmail.com','10-11-2020','ADMIN');

insert into comment(message, id_user, approved, created_at)
 VALUES ('Hello world',1,'APPROVED','10-11-2020');
--drop table comment,userFix;
--drop schema myapp CASCADE ;
