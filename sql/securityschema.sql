create table users(
      username varchar(50) not null primary key,
      password varchar(50) not null,
      enabled boolean not null);

  create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null)

ALTER TABLE `authorities`
	ADD CONSTRAINT `fk_authorities`
	FOREIGN KEY(`username`)
	REFERENCES `users`(`username`)
GO


ALTER TABLE authorities
add unique index(username, authority)
GO



create table groups (
  id int(11)  AUTO_INCREMENT NOT NULL,
  group_name varchar(50) not null,
primary key(id));


create table group_authorities (
  group_id int not null,
  authority varchar(50) not null,
  constraint fk_group_authorities_group foreign key(group_id) references groups(id));



create table group_members (
  id int  AUTO_INCREMENT NOT NULL primary key,
  username varchar(50) not null,
  group_id int not null,
  constraint fk_group_members_group foreign key(group_id) references groups(id));
        








