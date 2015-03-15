INSERT INTO person(firstname, lastname, username) VALUES ('Daniel','Schülke','daniel.schuelke');
INSERT INTO person(firstname, lastname, username) VALUES ('Max','Mustermann','max.mustermann');
INSERT INTO person(firstname, lastname, username) VALUES ('Susi','Sorglos','susi.sorglos');
INSERT INTO person(firstname, lastname, username) VALUES ('Tom','Taylor','tom.taylor');

INSERT INTO users (username,enabled,password) values ('daniel.schuelke', TRUE, '$2a$10$41iuDI6fDZcIS3qQqvugpecuGxoSU7iHiOuYxdkgos76XkhaO3YnW');
INSERT INTO user_roles (role, username) values ('USER','daniel.schuelke');

commit;