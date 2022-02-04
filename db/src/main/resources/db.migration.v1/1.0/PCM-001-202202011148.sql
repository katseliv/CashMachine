CREATE SCHEMA cashmachine;

CREATE TABLE cashmachine.users
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    mid_name   VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL
);

CREATE SEQUENCE cards_sequence START 1000000000000000;

CREATE TABLE cashmachine.cards
(
    id         BIGINT PRIMARY KEY DEFAULT nextval('cards_sequence'),
    balance    INTEGER NOT NULL,
    is_blocked BOOLEAN DEFAULT FALSE,
    pin_code   VARCHAR(50) NOT NULL,
    owner_id   INTEGER REFERENCES cashmachine.users (id) ON DELETE CASCADE NOT NULL
);

CREATE TABLE cashmachine.operations
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE cashmachine.operations_history
(
    id           SERIAL PRIMARY KEY,
    datetime     TIMESTAMPTZ NOT NULL,
    card_id      BIGINT REFERENCES cashmachine.cards (id) ON DELETE CASCADE NOT NULL,
    operation_id INTEGER REFERENCES cashmachine.users (id) ON DELETE CASCADE NOT NULL
);