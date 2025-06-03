use sign_up_form;

create table singing(
lastname nvarchar(255) not null,
firstname nvarchar(255) not null,
age INTEGER not null,
email nvarchar(255) not null,
password nvarchar(255) not null
);

alter table singing
add column id int auto_increment primary key ;
select * from singing;
