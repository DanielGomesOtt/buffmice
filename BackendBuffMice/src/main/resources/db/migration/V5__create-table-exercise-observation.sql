create table exercise_observation (
        id bigint not null auto_increment,
        exercise_id bigint not null,
        user_id bigint not null,
        observation text not null,
        status tinyint,

        primary key(id),
        constraint fk_exercise_observation_user_id foreign key(user_id) references users(id),
        constraint fk_exercise_observation_exercise_id foreign key(exercise_id) references exercise(id)

);