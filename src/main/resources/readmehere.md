-- DROP TABLE IF EXISTS order_item;
-- DROP TABLE IF EXISTS orders;
-- DROP TABLE IF EXISTS product;

-- CREATE TABLE product (
--     id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--     name VARCHAR(255) NOT NULL,
--     price DECIMAL(10, 2) NOT NULL,
--     category VARCHAR(255)
-- );

-- CREATE TABLE orders (
--     id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--     "date" DATE NOT NULL,
--     total_value DECIMAL(10, 2) NOT NULL
-- );

-- CREATE TABLE order_item (
--     id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--     product_id BIGINT NOT NULL,
--     order_id BIGINT NOT NULL,
--     price DECIMAL(10, 2) NOT NULL,
--     quantity INT NOT NULL,
--     CONSTRAINT fk_order_item_product FOREIGN KEY (product_id) REFERENCES product (id),
--     CONSTRAINT fk_order_item_order FOREIGN KEY (order_id) REFERENCES orders (id)
-- );