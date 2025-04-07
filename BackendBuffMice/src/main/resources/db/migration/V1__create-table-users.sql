create table users (
    id bigint not null auto_increment,
    name varchar(100),
    email varchar(100) unique,
    password varchar(255),
    status tinyint,

    primary key(id)
);