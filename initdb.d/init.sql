CREATE DATABASE IF NOT EXISTS balance;
CREATE DATABASE IF NOT EXISTS wallet;

use wallet;

create table clients (id varchar(254), name varchar(255), email varchar(255), created_at date);
create table accounts (id varchar(254), client_id varchar(255), balance int, created_at date);
create table transactions (id varchar(254), account_id_from varchar(255), account_id_to varchar(255), amount int, created_at date);

INSERT INTO clients (id, name, email, created_at)
VALUES ('4e593031-fad2-4c54-b076-844306449d82', 'Heitor','heitor@fc.com', NOW());

INSERT INTO clients (id, name, email, created_at)
VALUES ('6ed0064a-8df9-49f4-9851-611c9546fed1', 'Cintia','cintia@fc.com', NOW());

INSERT INTO clients (id, name, email, created_at)
VALUES ('5a5a39fd-d92e-4a49-9327-fcaf49a3bd33', 'Maria','maria@fc.com', NOW());

INSERT INTO accounts (id, client_id, balance, created_at)
VALUES ('30cc6a11-96ec-4171-9ac2-812e6bb2cf8d', '4e593031-fad2-4c54-b076-844306449d82', 100.0, NOW());

 INSERT INTO accounts (id, client_id, balance, created_at)
VALUES ('db8654e3-f0aa-416a-b796-4e68f9b9aa78', '5a5a39fd-d92e-4a49-9327-fcaf49a3bd33', 15.0, NOW());

 INSERT INTO accounts (id, client_id, balance, created_at)
VALUES ('9f4177de-f3a1-4519-a1ca-a1781dccfed2', '6ed0064a-8df9-49f4-9851-611c9546fed1', 0.0, NOW());
