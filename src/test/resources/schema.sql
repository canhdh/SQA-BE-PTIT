create table customer
(
    id             integer generated by default as identity,
    address        varchar(255),
    birthday       varchar(255),
    email          varchar(255),
    gender         varchar(255),
    id_card        varchar(255),
    marital_status varchar(255),
    name           varchar(255),
    nationality    varchar(255),
    phone_number   varchar(255),
    username       varchar(255),
    primary key (id)
);

create table loan
(
    id                           integer generated by default as identity,
    collateral                   varchar(255),
    created_date                 varchar(255),
    date_begin                   varchar(255),
    disbursed_amount             double,
    disbursement_date            varchar(255),
    expected_payment_date        varchar(255),
    id_customer                  integer,
    income                       double,
    loan_amount                  double,
    paid_amount                  double,
    proof_of_collateral_document varchar(255),
    proof_of_income_document     varchar(255),
    purpose                      varchar(255),
    status                       integer,
    primary key (id)
);

create table staff
(
    id       integer generated by default as identity,
    name     varchar(255),
    username varchar(255),
    primary key (id)
);
create table user
(
    id       integer generated by default as identity,
    password varchar(255),
    position varchar(255),
    username varchar(255),
    primary key (id)
);