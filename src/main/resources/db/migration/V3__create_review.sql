create table product_review (
                                id bigserial primary key,
                                product_id bigint not null,
                                user_id bigint,
                                rating int not null,
                                comment text,
                                created timestamp,
                                updated timestamp,

                                foreign key (product_id) references product(id),
                                foreign key (user_id) references users(id)
);

