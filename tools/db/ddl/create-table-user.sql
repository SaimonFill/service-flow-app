create table users
(
    id               int auto_increment
        primary key,
    uuid             varchar(36) default (uuid()) null,
    name             varchar(255)                 null,
    email            varchar(64)                  null,
    password_hash    varchar(255)                 not null,
    created          timestamp                    not null,
    created_by       varchar(64)                  not null,
    last_modified    timestamp                    null,
    last_modified_by varchar(64)                  null,
    constraint email
        unique (email),
    constraint name
        unique (name),
    constraint uuid unique (uuid)
);

insert into users (name, email, password_hash)
    value ('User', 'test@mail.com', '1234567');