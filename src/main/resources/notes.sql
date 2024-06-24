create table if not exists notes(
    id integer primary key,
    user_id integer,
    heading varchar(255),
    text CHARACTER LARGE OBJECT,
    foreign key(user_id) references users(id)
)