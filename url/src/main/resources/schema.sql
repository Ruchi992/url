CREATE TABLE url_info (
  id          INTEGER PRIMARY KEY auto_increment,
  short_url VARCHAR(64) NOT NULL,
  full_url   VARCHAR(100) NOT NULL);