CREATE TABLE examinee (
  u_id   BIGINT NOT NULL,
  e_id   BIGINT       NOT NULL,
  status ENUM ('COMPlETE', 'UNCOMPLETE') DEFAULT 'UNCOMPLETE',
  score  SMALLINT,
  PRIMARY KEY (u_id, e_id),
  FOREIGN KEY (u_id) REFERENCES user (id),
  FOREIGN KEY (e_id) REFERENCES exam (id)
)
