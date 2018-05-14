create database if not exists reservdb;
use reservdb;

drop table if exists staff;
drop table if exists client;
drop table if exists timeslot;
drop table if exists appointment;
drop table if exists request;

create table staff(
  staffId int not null auto_increment,
  firstname varchar(50),
  lastname varchar(50),
  phonenumber varchar(50),
  email varchar(50),
  username varchar(50),
  password varchar(50),
  primary key(staffId)
);

create table client(
  clientId int not null auto_increment,
  firstname varchar(50),
  lastname varchar(50),
  phonenumber varchar(50),
  email varchar(50),
  primary key(clientId)
);

create table timeslot(
  timeslotId int not null auto_increment,
  starttime datetime not null,
  endtime datetime not null,
  primary key(timeslotId)
);

create table appointment(
  appointmentId int not null auto_increment,
  timeslotId int not null,
  clientId int not null,
  primary key(appointmentId),
  foreign key(timeslotId) references timeslot(timeslotId),
  foreign key(clientId) references client(clientId)
);

-- type: 1 -> send a make appointment request, 0 -> send a cancel appointment request
-- state: 0 -> pending, 1 -> accept
create table request(
  requestId int not null auto_increment,
  type int not null default 1,
  state int not null default 0,
  appointmentId int not null,
  datetimeCreated datetime default current_timestamp,
  primary key(requestId),
  foreign key(appointmentId) references appointment(appointmentId)
);

insert into staff(staffId, firstname, lastname, phonenumber, email, username, password) values(1001, 'Carl', 'Y', '641-452-2298', 'carly@gmail.com', 'admin', 'admin');
insert into clien(clientId, firstname, lastname, phonenumber, email) values(2001, 'Eleven', 'K', '641-987-9987', 'elevenk@gmail.com');
insert into timeslot(timeslotId, starttime, endtime) values(3001, current_timestamp, current_timestamp);
insert into appointment(appointmentId, timeslotId, clientId) values(4001, 3001, 2001);
insert into request(requestId, appointmentId) values(5001, 4001);
