CREATE TABLE cases (
  disease_id   INT      NOT NULL,
  created_time BIGINT   NOT NULL,
  rand         SMALLINT NOT NULL,
  PRIMARY KEY (disease_id, created_time, rand),
  FOREIGN KEY (disease_id) REFERENCES disease (id),
  FOREIGN KEY (created_time, rand) REFERENCES article (created_time, rand)
)