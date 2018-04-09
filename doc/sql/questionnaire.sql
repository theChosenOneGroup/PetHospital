CREATE TABLE questionnaire (
  e_id BIGINT NOT NULL,
  q_id BIGINT NOT NULL,
  PRIMARY KEY (e_id, q_id),
  FOREIGN KEY (e_id) REFERENCES exam (id),
  FOREIGN KEY (q_id) REFERENCES question (id)
)