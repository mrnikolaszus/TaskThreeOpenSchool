--liquibase formatted sql

--changeset nickz:1

-- Создание таблицы users
CREATE TABLE IF NOT EXISTS users
(
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(64)        NOT NULL,
    email VARCHAR(64) UNIQUE NOT NULL
);

-- Создание таблицы orders
CREATE TABLE IF NOT EXISTS orders
(
    id          BIGSERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    status      VARCHAR(32) NOT NULL,
    user_id     BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);