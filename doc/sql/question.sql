CREATE TABLE question (
  id          BIGINT       NOT NULL,
  description VARCHAR(512) NOT NULL,
  type        ENUM ('RADIO', 'CHECKBOX', 'TEXT'),
  PRIMARY KEY (id)
)
  CHARACTER SET utf8;