CREATE TABLE ACCOUNT (
                         id VARCHAR(255) PRIMARY KEY,
                         account_type VARCHAR(255),
                         client_id VARCHAR(255),
                         balance DOUBLE,
                         withdraw_allowed BOOLEAN
);

INSERT INTO ACCOUNT (id, account_type, client_id, balance, withdraw_allowed)
VALUES ('1', 'SAVING', 'client123', 1000.0, true);

INSERT INTO ACCOUNT (id, account_type, client_id, balance, withdraw_allowed)
VALUES ('2', 'CHECKING', 'client456', 500.0, true);