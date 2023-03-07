create schema if not exists auth;

SET search_path TO auth;

DROP TABLE IF EXISTS users;

DROP TYPE IF EXISTS user_role;
CREATE TYPE user_role AS ENUM ('USER', 'ADMIN', 'GUEST');

DROP TYPE IF EXISTS user_status;
CREATE TYPE user_status AS ENUM ('ACTIVE', 'BANNED');

CREATE TABLE IF NOT EXISTS users
(
    id         SERIAL PRIMARY KEY,
    username   VARCHAR(100) not null unique,
    email      VARCHAR(100) not null unique,
    name       VARCHAR(100) not null,
    password   VARCHAR(255) NOT NULL,
    role       user_role DEFAULT 'USER',
    status     user_status DEFAULT 'ACTIVE',
    created    timestamp not null,
    updated    timestamp not null
);



