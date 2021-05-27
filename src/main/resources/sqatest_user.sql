create table user
(
    id       int auto_increment
        primary key,
    password varchar(255) null,
    position varchar(255) null,
    username varchar(255) null
)
    engine = MyISAM;

INSERT INTO sqatest.user (id, password, position, username) VALUES (1, '123', 'customer', 'canh@gmail.com');
INSERT INTO sqatest.user (id, password, position, username) VALUES (2, '123', 'staff', 'staff1@gmail.com');