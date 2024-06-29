CREATE TABLE user
(
    id             BIGINT              NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_user_name VARCHAR(255),
    cpf            BIGINT UNIQUE       NOT NULL,
    saldo          BIGINT DEFAULT 0    NOT NULL,
    email          VARCHAR(255) UNIQUE NOT NULL,
    password       VARCHAR(255),
    shopkeeper     BOOLEAN
);
