CREATE TABLE ACCOUNTS (
  id INTEGER PRIMARY KEY,
  user VARCHAR2(50) UNIQUE,
  password VARCHAR2(50) UNIQUE
);

INSERT INTO ACCOUNTS VALUES(1, 'Alex','aaaaaaa');
INSERT INTO ACCOUNTS VALUES(2, 'Tim', 'ttttttt');
INSERT INTO ACCOUNTS VALUES(3, 'Kyle', 'kkkkkkk');
--INSERT INTO ACCOUNTS VALUES(4, 'Brad', 'bbbbbbb');
