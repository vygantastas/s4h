drop table if exists s4h.providers;
CREATE TABLE IF NOT EXISTS s4h.providers
(id int NOT NULL AUTO_INCREMENT,
name VARCHAR(25) NOT NULL,
passw VARCHAR(20) not null,
phone varchar(12),
work int,
free DATETIME,
rating tinyint,
PRIMARY KEY (id));


