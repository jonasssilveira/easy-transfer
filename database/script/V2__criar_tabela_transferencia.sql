CREATE TABLE transfer
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    value              BIGINT,
    payer_id           BIGINT,
    payee_id           BIGINT NOT NULL,
    data_transferencia TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_payer FOREIGN KEY (payer_id)
        REFERENCES user (id),
    CONSTRAINT fk_payee FOREIGN KEY (payee_id)
        REFERENCES user (id)
);