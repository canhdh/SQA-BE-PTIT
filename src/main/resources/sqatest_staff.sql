create table staff
(
    id       int auto_increment
        primary key,
    name     varchar(255) null,
    username varchar(255) null
)
    engine = MyISAM;

INSERT INTO sqatest.staff (id, name, username) VALUES (1, 'Nguyễn Thu Ngân', 'staff1@gmail.com');