create table accounts
(
    id       bigserial
        constraint accounts_pk
            primary key,
    name     varchar not null,
    password varchar not null
);

INSERT INTO ACCOUNTS (NAME, PASSWORD) VALUES ('tester', '$2a$10$5R5YlyKkQbMvBXk6kXpxY.sQWkGE3gtcRC1wKEvL.oCn5VVNuSF3W');

create table messages
(
    sender_id    bigint not null
        constraint messages_accounts_id_fk
            references accounts,
    text_message varchar,
    id           bigserial
        constraint messages_pk
            primary key
);