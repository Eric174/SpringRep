DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), cost int, PRIMARY KEY (id));

INSERT INTO products (title, cost) VALUES ('Pen', 70);
INSERT INTO products (title, cost) VALUES ('Pencil', 80);
INSERT INTO products (title, cost) VALUES ('Apple', 100);
INSERT INTO products (title, cost) VALUES ('Banana', 200);
INSERT INTO products (title, cost) VALUES ('Kiwi', 90);
INSERT INTO products (title, cost) VALUES ('Lemon', 70);
INSERT INTO products (title, cost) VALUES ('Mango', 3000);
INSERT INTO products (title, cost) VALUES ('Cherry', 20);
INSERT INTO products (title, cost) VALUES ('Cashew', 110);
INSERT INTO products (title, cost) VALUES ('Peanut', 120);
INSERT INTO products (title, cost) VALUES ('Walnut', 150);

