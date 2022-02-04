ALTER TABLE cashmachine.cards
ALTER COLUMN pin_code TYPE VARCHAR(150);

INSERT INTO cashmachine.users (id, first_name, mid_name, last_name) VALUES
(0, 'Ekaterina', 'Aleksandrovna', 'Selivanova'),
(1, 'Maria', 'Ivanovna', 'Sidorova'),
(2, 'Mikhail', 'Alekseevich', 'Smirnov');

INSERT INTO cashmachine.cards (balance, is_blocked, pin_code, owner_id) VALUES
(100000, false, '$2a$10$zOHbWIMB0VMZl.9l0ZV40.aBINzxYbzJVYZWHbfewUlhxSUMJalaO', 0),
(30000, true, '$2a$10$zOHbWIMB0VMZl.9l0ZV40.aBINzxYbzJVYZWHbfewUlhxSUMJalaO', 1),
(5600, false, '$2a$10$zOHbWIMB0VMZl.9l0ZV40.aBINzxYbzJVYZWHbfewUlhxSUMJalaO', 2);

INSERT INTO cashmachine.operations (name) VALUES
('Check Balance'),
('Withdraw Cash');