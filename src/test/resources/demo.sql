--This script is used for unit test cases, DO NOT CHANGE!

DROP TABLE IF EXISTS User;

CREATE TABLE User (UserId LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,
 UserName VARCHAR(30) NOT NULL,
 EmailAddress VARCHAR(30) NOT NULL);

CREATE UNIQUE INDEX idx_ue on User(UserName,EmailAddress);

INSERT INTO User (UserName, EmailAddress) VALUES ('pasha','pasha.nag@gmail.com');
INSERT INTO User (UserName, EmailAddress) VALUES ('nissan','nissan.maxwell@gmail.com');
INSERT INTO User (UserName, EmailAddress) VALUES ('puertorico','rickme@gmail.com');

DROP TABLE IF EXISTS Account;

CREATE TABLE Account (AccountId LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,
UserName VARCHAR(30),
Balance DECIMAL(19,4),
CurrencyCode VARCHAR(30)
);

CREATE UNIQUE INDEX idx_acc on Account(UserName,CurrencyCode);

INSERT INTO Account (UserName,Balance,CurrencyCode) VALUES ('pasha',100.0000,'USD');
INSERT INTO Account (UserName,Balance,CurrencyCode) VALUES ('nissan',200.0000,'USD');
INSERT INTO Account (UserName,Balance,CurrencyCode) VALUES ('puertorico',500.0000,'EUR');
INSERT INTO Account (UserName,Balance,CurrencyCode) VALUES ('pasha',500.0000,'EUR');
INSERT INTO Account (UserName,Balance,CurrencyCode) VALUES ('nissan',500.0000,'GBP');
INSERT INTO Account (UserName,Balance,CurrencyCode) VALUES ('puertorico',500.0000,'GBP');
