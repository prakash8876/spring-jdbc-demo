create table Products (
    id number GENERATED BY DEFAULT AS IDENTITY,
    item varchar(50) not null,
    price number not null,
    primary key (id)
);

select * from Products;
insert into Products (item, price) values ('iPhone',31000);
insert into Products (item, price) values ('iPhone XR',51000);
insert into Products (item, price) values ('iPhone X',41000);
insert into Products (item, price) values ('iPhone 11',11000);
insert into Products (item, price) values ('iPhone 13',21000);

delete Products where products.item='iPhone 12';
commit;