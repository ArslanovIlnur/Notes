create table if not exists users(
    id integer primary key,
    username varchar(255) unique ,
    password varchar(255)
)