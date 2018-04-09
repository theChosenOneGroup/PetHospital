CREATE TABLE options (
  q_id        BIGINT       NOT NULL,
  sequence    TINYINT      NOT NULL,
  description VARCHAR(256) NOT NULL,
  valid       BOOLEAN      ,
  PRIMARY KEY (q_id, sequence),
  FOREIGN KEY (q_id) REFERENCES question (id)
)
  CHARACTER SET utf8;