/*
INSERT INTO role (description, name) VALUES ('Admin role', 'ADMIN');
INSERT INTO role (description, name) VALUES ('Manager role', 'MANAGER');
INSERT INTO role (description, name) VALUES ('User role', 'USER');

INSERT INTO usuarios(username, email, password) values ('user1', 'user1@user.com', '$2a$10$hjdjJ/M3YF.6h7fIo8PJUOjy34yMt1rF.Y3rhwAt9zJ909vXdCCu.');
INSERT INTO user_roles(user_id, role_id) values (1, 3);

INSERT INTO usuarios(username, email, password) values ('user2', 'user2@moderador.com', '$2a$10$hjdjJ/M3YF.6h7fIo8PJUOjy34yMt1rF.Y3rhwAt9zJ909vXdCCu.');
INSERT INTO user_roles(user_id, role_id) values (2, 1);
*/