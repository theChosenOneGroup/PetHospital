CREATE TABLE department (
  id           SMALLINT     NOT NULL,
  name         VARCHAR(255) NOT NULL UNIQUE,
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  category VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE disease (
  id           INT          NOT NULL,
  d_id         SMALLINT     NOT NULL,
  name         VARCHAR(255) NOT NULL,
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (d_id) REFERENCES department (id)
);

INSERT INTO department (id, name) VALUES
  (1, 'huxineike'),
  (2, 'shaoshangneike'),
  (3, 'mianyineike'),
  (4, 'neifenmike'),
  (5, 'shenjingneike');

INSERT INTO disease (id, name, d_id) VALUES
  (1, 'fengshibing', 1),
  (2, 'xinzangbing', 1),
  (3, 'tangniaobing', 2),
  (4, 'guzhishusong', 2),
  (5, 'naoxueshuan', 3)
