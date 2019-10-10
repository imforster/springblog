CREATE TABLE USER (
  USER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  USERNAME VARCHAR(128) NOT NULL UNIQUE,
  PASSWORD VARCHAR(256) NOT NULL,
  FIRSTNAME VARCHAR(64) NOT NULL,
  LASTNAME VARCHAR(64) NOT NULL
);

CREATE TABLE AUTH_USER_GROUP (
  AUTH_USER_GROUP_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  USERNAME VARCHAR(128) NOT NULL,
  AUTH_GROUP VARCHAR(128) NOT NULL,
  CONSTRAINT USER_AUTH_USER_GROUP_FK FOREIGN KEY(USERNAME) REFERENCES USER(USERNAME),
  UNIQUE (USERNAME, AUTH_GROUP)
);