CREATE TABLE transfer
(
    id                 BIGSERIAL PRIMARY KEY,
    value              BIGINT,
    payer_id           BIGINT NOT NULL,
    payee_id           BIGINT NOT NULL,
    data_transferencia TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
        CONSTRAINT fk_payer FOREIGN KEY (payer_id)
            REFERENCES user (id),
    CONSTRAINT fk_payee
        FOREIGN KEY (payee_id)
            REFERENCES user (id)
);