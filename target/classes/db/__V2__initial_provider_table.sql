CREATE TABLE IF NOT EXISTS s4h.languages
(
lang_id int NOT NULL AUTO_INCREMENT primary key,
user_id int NOT NULL,
lang_first VARCHAR(20) NOT NULL,
lang_second VARCHAR(20) NOT NULL,
direction tinyint,
work int,
free DATE,
rating tinyint,

FOREIGN KEY FK_USER (user_id) REFERENCES s4h.providers (id)
);