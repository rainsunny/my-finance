-- create database
create database accounting;

-- create tables
-- account table

create table tb_account
(
account_id varchar(20) primary key,
account_name varchar(100) not null,
description varchar(300),
balance double (12, 2),
parent_id varchar(20),
account_type varchar(20) not null,
account_state varchar(20) not null,
create_time datetime,
update_time datetime
);

-- account detail table
create table tb_account_detail
(
detail_id serial primary key,
account_id varchar(20) not null,
debit_credit tinyint(1) not null, -- 0 debit 出账,  1 credit 进账
operation_amount double (12,2) not null,
account_balance double (12,2) not null,
create_time datetime,
update_time datetime
);


-- sequence
DROP TABLE IF EXISTS sequence;
CREATE TABLE sequence (
name              VARCHAR(50) NOT NULL,
current_value INT NOT NULL,
increment       INT NOT NULL DEFAULT 1,
PRIMARY KEY (name)
) ENGINE=InnoDB;
-- INSERT INTO sequence VALUES ('MovieSeq',3,5);

DROP FUNCTION IF EXISTS currval;
DELIMITER $
CREATE FUNCTION currval (seq_name VARCHAR(50))
RETURNS INTEGER
CONTAINS SQL
BEGIN
  DECLARE value INTEGER;
  SET value = 0;
  SELECT current_value INTO value
  FROM sequence
  WHERE name = seq_name;
  RETURN value;
END$
DELIMITER ;

DROP FUNCTION IF EXISTS nextval;
DELIMITER $
CREATE FUNCTION nextval (seq_name VARCHAR(50))
  RETURNS INTEGER
CONTAINS SQL
  BEGIN
    UPDATE sequence
    SET          current_value = current_value + increment
    WHERE name = seq_name;
    RETURN currval(seq_name);
  END$
DELIMITER ;

DROP FUNCTION IF EXISTS setval;
DELIMITER $
CREATE FUNCTION setval (seq_name VARCHAR(50), value INTEGER)
  RETURNS INTEGER
CONTAINS SQL
  BEGIN
    UPDATE sequence
    SET          current_value = value
    WHERE name = seq_name;
    RETURN currval(seq_name);
  END$
DELIMITER ;

-- sequence for account_id
insert into sequence values ('account_seq', 0, 1);