INSERT INTO customer (address, birthday, email, gender, id_card, marital_status, name, nationality, phone_number, username) VALUES ('Van Duc', '2021-05-04', 'test1@gmail.com', 'Nam', '1225132541643', 'Đã có gia đình', 'Nguyễn Cầm Cố', 'USA', '0123456789', 'canh@gmail.com');
INSERT INTO customer (address, birthday, email, gender, id_card, marital_status, name, nationality, phone_number, username) VALUES ('Ha Noi', '2021-05-04', 'test2@gmail.com', 'Nam', '1225143241612', 'Đã có gia đình', 'Trần Nợ', 'Việt Name', '0987654321', 'user@gmail.com');

INSERT INTO loan (collateral, created_date, date_begin, id_customer, income, loan_amount, proof_of_collateral_document, proof_of_income_document, purpose, status, expected_payment_date, disbursed_amount, disbursement_date, paid_amount) VALUES ('Nhà cửa', '2021-05-23', '2021-05-12', 1, 1000000, 100000000, null, null, 'Mua bitcoins', 2, '2021-05-23', 40000000, null, 0);
INSERT INTO loan (collateral, created_date, date_begin, id_customer, income, loan_amount, proof_of_collateral_document, proof_of_income_document, purpose, status, expected_payment_date, disbursed_amount, disbursement_date, paid_amount) VALUES ('Nhà cửa', '2021-05-23', '2021-05-05', 1, 10000000, 100000000, null, null, 'Dau tu chung khoan', 2, '2021-05-23', 0, null, 0);
INSERT INTO loan (collateral, created_date, date_begin, id_customer, income, loan_amount, proof_of_collateral_document, proof_of_income_document, purpose, status, expected_payment_date, disbursed_amount, disbursement_date, paid_amount) VALUES ('Nhà cửa', '2021-05-23', '2021-05-12', 1, 10000000, 1000000000, null, null, null, 1, '2021-05-23', 10000000, null, 0);
INSERT INTO loan (collateral, created_date, date_begin, id_customer, income, loan_amount, proof_of_collateral_document, proof_of_income_document, purpose, status, expected_payment_date, disbursed_amount, disbursement_date, paid_amount) VALUES ('Đất đai', '2021-05-23', '2021-05-12', 1, 100012000, 1241325235, null, null, null, 1, '2021-05-23', 120000000, null, 0);
INSERT INTO loan (collateral, created_date, date_begin, id_customer, income, loan_amount, proof_of_collateral_document, proof_of_income_document, purpose, status, expected_payment_date, disbursed_amount, disbursement_date, paid_amount) VALUES ('Nhà cửa', '2021-05-27', '2021-05-03', 1, 10000000, 100000000, null, null, 'Ban', 1, '2021-05-28', 0, null, 0);

INSERT INTO staff (name, username) VALUES ('Nguyễn Thu Ngân', 'staff1@gmail.com');
INSERT INTO staff (name, username) VALUES ('Đỗ Thu Phí', 'user@gmail.com');

INSERT INTO user (password, position, username) VALUES ('123', 'customer', 'canh@gmail.com');
INSERT INTO user (password, position, username) VALUES ('123', 'staff', 'staff1@gmail.com');