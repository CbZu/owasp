CREATE TABLE users(
    id SERIAL primary key not null ,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(50) not null,
    password text not null
);

CREATE TABLE post(
    id SERIAL primary key not null ,
    title varchar(100) not null,
    content varchar(200) not null,
    user_id INT not null,
    FOREIGN KEY(user_id) REFERENCES users(id)
);