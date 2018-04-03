CREATE TABLE user (
  id       BIGINT AUTO_INCREMENT  NOT NULL,
  name     VARCHAR(255)           NOT NULL,
  mail     VARCHAR(128) UNIQUE    NOT NULL,
  role     ENUM ('Admin', 'User') NOT NULL,
  valid    BOOLEAN                NOT NULL DEFAULT TRUE,
  address  VARCHAR(255),
  password VARCHAR(255)           NOT NULL,
  PRIMARY KEY (id),
  INDEX mail_index (mail)
);

INSERT INTO user (name, mail, role, address, password) VALUES
  ('John', 'john@google.com', 'Admin', 'Springfield', 'password'),
  ('Smith', 'smith@hotmail.com', 'User', 'Franklin', 'password'),
  ('Fancy', 'fancy@happy.day', 'User', 'Salem', 'password'),
  ('Lucy', 'lucy@firebird.com', 'Admin', 'Los Angels', 'password'),
  ('Trump', 'Trump@whitehouse.com', 'Admin', 'Clinton','password');
