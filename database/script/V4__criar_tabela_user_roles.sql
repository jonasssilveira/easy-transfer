CREATE TABLE role_user
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_user_id FOREIGN KEY (user_id)
        REFERENCES user (id),
    CONSTRAINT fk_payeefk_role_id FOREIGN KEY (role_id)
        REFERENCES role (id)
)