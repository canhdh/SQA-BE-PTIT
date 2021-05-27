create table loan
(
    id                           int auto_increment
        primary key,
    collateral                   varchar(255) null,
    created_date                 varchar(255) null,
    date_begin                   varchar(255) null,
    excepted_payment_date        varchar(255) null,
    id_customer                  int          null,
    income                       float        null,
    loan_amount                  int          null,
    proof_of_collateral_document varchar(255) null,
    proof_of_income_document     varchar(255) null,
    purpose                      varchar(255) null,
    status                       int          null
)
    engine = MyISAM;

INSERT INTO sqatest.loan (id, collateral, created_date, date_begin, excepted_payment_date, id_customer, income, loan_amount, proof_of_collateral_document, proof_of_income_document, purpose, status, expected_payment_date, disbursed_amount, not_disbursed_amount, disbursement_date, paid_amount) VALUES (1, 'Nhà cửa', '2021-05-23', '2021-05-12', '2021-05-28', 1, 1000000, 100000000, null, null, 'Mua bitcoins', 2, '2021-05-23', 40000000, null, null, 0);
INSERT INTO sqatest.loan (id, collateral, created_date, date_begin, excepted_payment_date, id_customer, income, loan_amount, proof_of_collateral_document, proof_of_income_document, purpose, status, expected_payment_date, disbursed_amount, not_disbursed_amount, disbursement_date, paid_amount) VALUES (2, 'Nhà cửa', '2021-05-23', '2021-05-05', '2021-05-19', 1, 10000000, 100000000, null, null, 'Dau tu chung khoan', 2, '2021-05-23', 0, null, null, 0);
INSERT INTO sqatest.loan (id, collateral, created_date, date_begin, excepted_payment_date, id_customer, income, loan_amount, proof_of_collateral_document, proof_of_income_document, purpose, status, expected_payment_date, disbursed_amount, not_disbursed_amount, disbursement_date, paid_amount) VALUES (3, 'Nhà cửa', '2021-05-23', '2021-05-12', '2021-06-04', 1, 10000000, 1000000000, null, null, null, 1, '2021-05-23', 10000000, null, null, 0);
INSERT INTO sqatest.loan (id, collateral, created_date, date_begin, excepted_payment_date, id_customer, income, loan_amount, proof_of_collateral_document, proof_of_income_document, purpose, status, expected_payment_date, disbursed_amount, not_disbursed_amount, disbursement_date, paid_amount) VALUES (4, '''Đất đai', '2021-05-23', '2021-05-12', '2021-06-16', 1, 100012000, 1241325235, null, null, null, 1, '2021-05-23', 120000000, null, null, 0);
INSERT INTO sqatest.loan (id, collateral, created_date, date_begin, excepted_payment_date, id_customer, income, loan_amount, proof_of_collateral_document, proof_of_income_document, purpose, status, expected_payment_date, disbursed_amount, not_disbursed_amount, disbursement_date, paid_amount) VALUES (5, 'Nhà cửa', '2021-05-27', '2021-05-03', null, 1, 10000000, 100000000, null, null, 'Ban', 1, '2021-05-28', 0, null, null, 0);