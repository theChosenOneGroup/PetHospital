CREATE TABLE job (
  id           BIGINT                             NOT NULL,
  name         VARCHAR(64)                        NOT NULL,
  position     ENUM ('FRONT', 'ASSISTANT', 'VET') NOT NULL,
  description  VARCHAR(256),
  created_time BIGINT                             NOT NULL,
  rand         SMALLINT                           NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (created_time, rand) REFERENCES article (created_time, rand)
)
  CHARACTER SET utf8;