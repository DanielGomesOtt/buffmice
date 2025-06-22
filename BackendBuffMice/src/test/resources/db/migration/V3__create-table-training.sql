create table training (
    id bigint not null auto_increment,
    title varchar(255),
    limit_date date,
    status tinyint,
    users_id bigint not null,

    primary key(id),
    constraint fk_training_users_id foreign key(users_id) references users(id)
);