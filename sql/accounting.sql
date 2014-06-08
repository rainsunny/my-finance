-- create database
create database accounting;

-- create tables
-- account table

create table tb_account
(
account_id varchar(20) primary key,
account_name varchar(100) not null,
desc varchar(300),
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