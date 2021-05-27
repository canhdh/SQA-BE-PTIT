create table customer
(
    id             int auto_increment
        primary key,
    address        varchar(255) null,
    birthday       varchar(255) null,
    email          varchar(255) null,
    gender         varchar(255) null,
    id_card        varchar(255) null,
    marital_status varchar(255) null,
    name           varchar(255) null,
    nationality    varchar(255) null,
    phone_number   varchar(255) null,
    username       varchar(255) null
)
    engine = MyISAM;

INSERT INTO sqatest.customer (id, address, birthday, email, gender, id_card, marital_status, name, nationality, phone_number, username) VALUES (1, 'Van Duc', '2021-05-04', 'test1@gmail.com', 'Nam', '1225132541643', 'Đã có gia đình', 'Nguyễn Cầm Cố', 'USA', '0123456789', 'canh@gmail.com');