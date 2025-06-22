create table exercise (
    id bigint not null auto_increment,
    name varchar(255),
    description text,
    muscle varchar(255),
    secondary_muscle varchar(255),
    gif_url varchar(255),

    primary key(id)
)