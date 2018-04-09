CREATE TABLE exam (
  id     BIGINT       NOT NULL,
  title  VARCHAR(256) NOT NULL,
  start  DATETIME,
  end    DATETIME,
  length INT,
  PRIMARY KEY (id)
)
  CHARACTER SET utf8;