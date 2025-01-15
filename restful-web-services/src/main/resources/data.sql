insert into user_details(id,birth_date,name)
values (1001,current_date(),'Ranga');

insert into user_details(id,birth_date,name)
values (1002,current_date(),'Habibi');

insert into user_details(id,birth_date,name)
values (1003,current_date(),'9/11');

insert into post(id,description,user_id)
values (2001,'i want to learn docker',1001);

insert into post(id,description,user_id)
values (2002,'i want to learn aws',1001);

insert into post(id,description,user_id)
values (2003,'i want to learn kubernetes',1002);