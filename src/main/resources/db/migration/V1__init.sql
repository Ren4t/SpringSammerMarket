create table categories (id bigserial primary key, title varchar(255));
insert into categories (title)
values
('Food');

create table products (id bigserial primary key, title varchar(255), price int, category_id bigint references categories (id));
insert into products (title, price, category_id)
values
('Milk', 85, 1),
('Bread', 25, 1),
('Cheese', 450, 1),
('Coffee',500,1),
('Potatoes',20,1),
('Carrot',30,1),
('Onion',50,1),
('Apples',120,1),
('Lemon',300,1),
('Honey',600,1),
('Eggs',65,1),
('Vegetable oil',195,1),
('Soy sauce',200,1),
('Common vinegar',150,1),
('Green beans',50,1),
('Margarine',50,1),
('Butter',100,1),
('Boiled mushrooms',200,1),
('Spinach',150,1),
('Fish',300,1),
('Crab sticks',85,1);

