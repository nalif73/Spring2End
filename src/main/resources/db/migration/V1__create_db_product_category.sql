CREATE TABLE category
(
    id        bigserial primary key,
    name      text not null,
    alias     text not null
);

CREATE TABLE product (
    id serial primary key,
    name text not null,
    description text not null,
    price int not null,
    category_id int not null,
    image_link text,

        foreign key (category_id) references category(id)
);

INSERT INTO category (name, alias)
VALUES ('Продукты', 'product'),
       ('Электроника', 'electronics'),
       ('Одежда', 'clothes')
;

INSERT INTO product (name,  description, price, category_id)
VALUES ('Вода', 'питьевая вода', 20, 1),
       ('Пальто', 'пальто женское', 35, 3),
       ('Рубашка', 'рубашки для всех', 20, 3),
       ('Чай', 'чай в пакетах', 9, 1),
       ('CD-проигрыватель', 'сд-проигрыватель дисков', 100, 2),
       ('Молоко', 'молоко в пакетах', 13, 1),
       ('Смартфон', 'смартфон 2020 года выпуска', 89, 2),
       ('Брюки', 'брюки мужские', 13, 3),
       ('Телевизор', 'телевизор 32 дюйма', 13, 2)
;



