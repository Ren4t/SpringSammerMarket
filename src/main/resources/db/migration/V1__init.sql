create table users (
    id bigserial,
    username varchar(30) not null unique,
    password varchar(80) not null,
    email varchar(50) unique,
    primary key (id)
);

create table roles (
    id serial,
    name varchar(50) not null,
    primary key (id)
);

create table users_roles (
    user_id bigint not null,
    role_id int not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN'), ('READ_ALL_MESSAGE');

insert into users (username, password, email)
values
('user1','100','user111@email.com'),
('user2','200','user222@email.com');

insert into users_roles (user_id, role_id)
values
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(2, 3);

create table categories
(
    id         bigserial primary key,
    title      varchar(255),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into categories (title) values ('Food');

create table products
(
    id          bigserial primary key,
    title       varchar(255),
    price       numeric(8,2) not null,
    category_id bigint references categories (id),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);
insert into products (title, price,category_id)
values
('Milk', 85,1),
('Bread', 25,1),
('Cheese', 450,1),
('Coffee',500,1),
('Potatoes',20,1),
('Carrot',30,1),
('Onion',50,1),
('Apples',120,1),
('Lemon',300,1),
('Honey',600,1),
('Eggs',65,1),
('Vegetable oil2',195,1),
('Soy sauce2',200,1),
('Common vinegar2',150,1),
('Green beans2',50,1),
('Margarine2',50,1),
('Butter2',100,1),
('Bread2', 25,1),
('Cheese2', 450,1),
('Coffee2',500,1),
('Potatoes2',20,1),
('Carrot2',30,1),
('Onion2',50,1),
('Apples2',120,1),
('Lemon2',300,1),
('Honey2',600,1),
('Eggs2',65,1),
('Vegetable oil',195,1),
('Soy sauce',200,1),
('Common vinegar',150,1),
('Green beans',50,1),
('Margarine',50,1),
('Butter',100,1),
('Boiled mushrooms',200,1),
('Spinach',150,1),
('Fish',300,1);
