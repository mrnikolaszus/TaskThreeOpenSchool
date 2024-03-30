--liquibase formatted sql

--changeset nickz:1

--users
INSERT INTO users (name, email)
VALUES ('Test User1', 'user1@example.com'),
       ('Test User2', 'user2@example.com'),
       ('Test User3', 'user3@example.com'),
       ('Test User4', 'user4@example.com'),
       ('Test User5', 'user5@example.com'),
       ('Test User6', 'user6@example.com'),
       ('Test User7', 'user7@example.com'),
       ('Test User8', 'user8@example.com'),
       ('Test User9', 'user9@example.com'),
       ('Test User10', 'user10@example.com');

--orders
INSERT INTO orders (description, status, user_id)
VALUES ('Order 1', 'NEW', 1),
       ('Order 2', 'PROCESSING', 1),
       ('Order 1', 'NEW', 2),
       ('Order 2', 'PROCESSING', 3),
       ('Order 3', 'SHIPPED', 3),
       ('Order 1', 'NEW', 4),
       ('Order 2', 'DELIVERED', 4),
       ('Order 1', 'NEW', 5),
       ('Order 1', 'PROCESSING', 6),
       ('Order 2', 'SHIPPED', 7),
       ('Order 1', 'DELIVERED', 8),
       ('Order 1', 'NEW', 9),
       ('Order 2', 'PROCESSING', 10);