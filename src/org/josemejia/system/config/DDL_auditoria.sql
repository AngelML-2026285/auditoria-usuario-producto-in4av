drop database if exists auditoria_usuario_producto_in4av;
create database auditoria_usuario_producto_in4av;
use auditoria_usuario_producto_in4av;

create table Users(
	name varchar(50) not null check(length(name)<=50),
    lastname varchar(50) not null check(length(lastname)<=50),
    email varchar(50) not null check(length(email)<=50),
    user varchar(25) not null check(length(user)<=25),
    password varchar(35) not null check(length(password)<=35),
    id_user varchar(36) not null,
    constraint pk_users primary key (id_user)
);


drop procedure if exists sp_create_users;
Delimiter $$

create procedure sp_create_users(
    in name_p varchar(50),
    in lastname_p varchar(50),
    in email_p varchar(50),
    in user_p varchar(25),
    in password_p varchar(35)
)
begin

    insert into Users(name, lastname, email, user, password, id_user)
        values(name_p, lastname_p, email_p, user_p, password_p, uuid());

end$$

delimiter ;


drop procedure if exists sp_find_user_by_email;
Delimiter $$

create procedure sp_find_user_by_email(
    in email_p varchar(50)
)
begin

    select * from Users where email = email_p;

end$$

delimiter ;


drop procedure if exists sp_find_user_by_identifier;
Delimiter $$

create procedure sp_find_user_by_identifier(
    in identifier_p varchar(50)
)
begin

    select * from Users where email = identifier_p or user = identifier_p;

end$$

delimiter ;


drop procedure if exists sp_login;
Delimiter $$

create procedure sp_login(
    in identifier_p varchar(50),
    in password_p varchar(35)
)
begin

    select * from Users where (email = identifier_p or user = identifier_p) and password = password_p;

end$$

delimiter ;

call sp_create_users("a","a","a@", "a", "a123");

select * from users;

