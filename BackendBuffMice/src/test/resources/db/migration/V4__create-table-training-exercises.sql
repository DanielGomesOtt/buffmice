create table training_exercises (
    id bigint not null auto_increment,
    training_id bigint not null,
    exercise_id bigint not null,
    status tinyint,

    primary key(id),
    constraint fk_training_exercises_training_id foreign key(training_id) references training(id),
    constraint fk_training_exercises_exercise_id foreign key(exercise_id) references exercise(id)
);