-- 删除数据库
DROP DATABASE booksystem;
-- 创建数据库
CREATE DATABASE booksystem;
-- 使用数据库
USE booksystem;
-- 删除数据表

-- 创建数据表
-- 1、创建管理员表
CREATE TABLE admin (
  aid                  VARCHAR(50) NOT NULL ,
  password             VARCHAR(32),
  lastdate             DATETIME,--最后一次登录日
  flag                 INT,
  status               INT,
  CONSTRAINT  pk_aid PRIMARY KEY (aid)
);
-- 2、用户表
CREATE TABLE member (
  mid                  VARCHAR(50) not null,
  name                 VARCHAR(50),
  age                  INT,
  sex                  INT,
  phone                VARCHAR(32),
  CONSTRAINT  pk_mid PRIMARY KEY (mid)
);
-- 3、类别表
CREATE TABLE  item(
  iid                  INT not null AUTO_INCREMENT,
  name                 VARCHAR(100),
  note                 TEXT,
  CONSTRAINT pk_iid PRIMARY KEY (iid)
);

-- 4、课程详情表

CREATE TABLE books (
  bid                  INT not null AUTO_INCREMENT,
  iid                  INT,
  aid                  VARCHAR(50),
  name                 VARCHAR(100),
  credate              DATETIME,
  status               INT,
  note                 TEXT,
  CONSTRAINT pk_bid PRIMARY KEY (bid),
  CONSTRAINT fk_iid FOREIGN KEY (iid) REFERENCES item(iid) ON DELETE CASCADE,
  CONSTRAINT fk_aid FOREIGN KEY (aid) REFERENCES admin(aid) ON DELETE CASCADE
);
-- 5、借书详情表
CREATE TABLE lenbook (
  leid                 INT not null AUTO_INCREMENT,
  bid                  INT,
  mid                  VARCHAR(50),
  credate              DATETIME,
  retdate              DATETIME,
  CONSTRAINT pk_leid PRIMARY KEY (leid),
  CONSTRAINT fk_bid FOREIGN KEY (bid) REFERENCES books(bid) ON DELETE CASCADE,
  CONSTRAINT fk_mid FOREIGN KEY (mid) REFERENCES member(mid) ON DELETE CASCADE
);

-- 增加测试数据
-- 管理员ID:admin ,管理员密码:ylcto
INSERT INTO admin(aid,password,flag,status)VALUES ('admin','09BDE7C801111CB40BFD47EBAA6C4343',1,1);
-- 提交
COMMIT;