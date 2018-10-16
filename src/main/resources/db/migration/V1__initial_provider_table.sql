
CREATE TABLE IF NOT EXISTS s4h.providers
(id int  AUTO_INCREMENT,
name VARCHAR(25) NOT NULL,
passw VARCHAR(20) not null,
phone varchar(12),
PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS s4h.languages
(
lang_id int AUTO_INCREMENT PRIMARY KEY,
prov_id int NOT NULL,
first VARCHAR(20) NOT NULL,
second VARCHAR(20) NOT NULL,
direction tinyint,
work int,
free DATE,
rating tinyint,

FOREIGN KEY FK_USER (prov_id) REFERENCES s4h.providers (id)
);