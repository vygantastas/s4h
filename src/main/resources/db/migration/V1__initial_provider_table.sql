
CREATE TABLE IF NOT EXISTS s4h.providers
(id int  AUTO_INCREMENT,
username VARCHAR(25) NOT NULL,
password VARCHAR(20) not null,
name VARCHAR(25),
phone varchar(12),
sort varchar(1),
PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS s4h.languages
(
lang_id int AUTO_INCREMENT PRIMARY KEY,
prov_id int NOT NULL,
first VARCHAR(20) NOT NULL,
second VARCHAR(20) NOT NULL,
work int,
free DATE,
rating tinyint,
price float,
FOREIGN KEY FK_USER (prov_id) REFERENCES s4h.providers (id)
);