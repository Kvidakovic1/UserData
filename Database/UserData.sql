# c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < E:\Java\Java_Learning\SQL_Exercises\korisnicki_podaci.sql

drop database if exists podaci;
create database podaci;
use podaci;

create table user(
    user_id int not null primary key auto_increment,
    firstname varchar(80),
    lastname varchar(80),
    email varchar(50),
    username varchar(80),
    password varchar(50)
);


create table user_adress(
    user_adress_id int not null primary key auto_increment,
    user_id int,
    city varchar(80),
    street varchar(80),
    number varchar(40) # u slucaju da adresa sadrzi slovo u sebi
);

alter table user_adress add foreign key (user_id) references user(user_id);