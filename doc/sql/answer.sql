CREATE TABLE answer (
  u_id     BIGINT NOT NULL,
  e_id     BIGINT NOT NULL,
  q_id     BIGINT NOT NULL,
  sequence TINYINT,
  phrase   VARCHAR(512),
  PRIMARY KEY (u_id, e_id, q_id),
  FOREIGN KEY (q_id) REFERENCES question (id),
  FOREIGN KEY (u_id) REFERENCES user (id),
  FOREIGN KEY (e_id) REFERENCES exam (id)
)
  CHARACTER SET utf8;