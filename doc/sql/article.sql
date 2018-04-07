CREATE TABLE article (
  created_time BIGINT NOT NULL,
  rand         SMALLINT NOT NULL,
  description  VARCHAR(255),
  PRIMARY KEY (created_time, rand)
);

CREATE TABLE record (
  created_time BIGINT   NOT NULL,
  rand         SMALLINT NOT NULL,
  sequence     SMALLINT NOT NULL,
  priority     SMALLINT,
  content_type VARCHAR(100),
  description  VARCHAR(255),
  PRIMARY KEY (created_time, rand, sequence),
  FOREIGN KEY (created_time, rand) REFERENCES article (created_time, rand)
);

INSERT INTO article VALUES
  (TIMESTAMPDIFF(SECOND, '1970-1-1 0:0:0', current_timestamp) * 1000, 1, 'Test Article 1'),
  (TIMESTAMPDIFF(SECOND, '1970-1-1 0:0:0', current_timestamp) * 1000, 2, 'Test Article 2'),
  (TIMESTAMPDIFF(SECOND, '1970-1-1 0:0:0', current_timestamp) * 1000, 3, 'Test Article 3'),
  (TIMESTAMPDIFF(SECOND, '1970-1-1 0:0:0', current_timestamp) * 1000, 4, 'Test Article 4'),
  (TIMESTAMPDIFF(SECOND, '1970-1-1 0:0:0', current_timestamp) * 1000, 5, 'Test Article 5');
