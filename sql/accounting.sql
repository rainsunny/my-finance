-- create database
CREATE DATABASE accounting;

-- create tables
-- account table
DROP TABLE IF EXISTS tb_account;
CREATE TABLE tb_account
(
  account_id    SERIAL,
  account_name  VARCHAR(100) NOT NULL,
  description   VARCHAR(300),
  balance       DOUBLE(12, 2),
  owner         VARCHAR(20)  NOT NULL,
  account_type  VARCHAR(20)  NOT NULL,
  sub_type      VARCHAR(20)  NOT NULL,
  category      VARCHAR(200),
  account_state VARCHAR(20)  NOT NULL,
  create_time   DATETIME,
  update_time   DATETIME,
  PRIMARY KEY (account_id)
);

-- account detail table
DROP TABLE IF EXISTS tb_account_detail;
CREATE TABLE tb_account_detail
(
  detail_id        SERIAL,
  account_id       VARCHAR(20)   NOT NULL,
  debit_credit     TINYINT(1)    NOT NULL, -- 0 debit 出账,  1 credit 进账
  operation_amount DOUBLE(12, 2) NOT NULL,
  account_balance  DOUBLE(12, 2) NOT NULL,
  create_time      DATETIME,
  update_time      DATETIME,
  PRIMARY KEY (detail_id)
);


-- sequence
DROP TABLE IF EXISTS sequence;
CREATE TABLE sequence (
  name          VARCHAR(50) NOT NULL,
  current_value INT         NOT NULL,
  increment     INT         NOT NULL DEFAULT 1,
  PRIMARY KEY (name)
)
  ENGINE =InnoDB;
-- INSERT INTO sequence VALUES ('MovieSeq',3,5);

DROP FUNCTION IF EXISTS currval;
DELIMITER $
CREATE FUNCTION currval(seq_name VARCHAR(50))
  RETURNS INTEGER
CONTAINS SQL
  BEGIN
    DECLARE value INTEGER;
    SET value = 0;
    SELECT
      current_value
    INTO value
    FROM sequence
    WHERE name = seq_name;
    RETURN value;
  END$
DELIMITER ;

DROP FUNCTION IF EXISTS nextval;
DELIMITER $
CREATE FUNCTION nextval(seq_name VARCHAR(50))
  RETURNS INTEGER
CONTAINS SQL
  BEGIN
    UPDATE sequence
    SET current_value = current_value + increment
    WHERE name = seq_name;
    RETURN currval(seq_name);
  END$
DELIMITER ;

DROP FUNCTION IF EXISTS setval;
DELIMITER $
CREATE FUNCTION setval(seq_name VARCHAR(50), value INTEGER)
  RETURNS INTEGER
CONTAINS SQL
  BEGIN
    UPDATE sequence
    SET current_value = value
    WHERE name = seq_name;
    RETURN currval(seq_name);
  END$
DELIMITER ;

-- sequence for account_id
INSERT INTO sequence VALUES ('account_seq', 0, 1);