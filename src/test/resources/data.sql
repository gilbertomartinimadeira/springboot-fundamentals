INSERT INTO product (id, name, price, category) VALUES
(1, 'Laptop', 1200.00, 'Electronics'),
(2, 'Smartphone', 800.00, 'Electronics'),
(3, 'Desk Chair', 150.00, 'Furniture'),
(4, 'Coffee Maker', 60.00, 'Appliances'),
(5, 'Headphones', 100.00, 'Electronics'),
(6, 'Backpack', 45.00, 'Accessories'),
(7, 'Water Bottle', 15.00, 'Accessories'),
(8, 'Desk Lamp', 35.00, 'Furniture'),
(9, 'Keyboard', 70.00, 'Electronics'),
(10, 'Monitor', 300.00, 'Electronics');

INSERT INTO orders (id, `date`, total_value) VALUES
(1, '2026-08-01', 2310.00),
(2, '2026-08-05', 465.00),
(3, '2026-08-10', 3070.00);

INSERT INTO order_item (product_id, order_id, price, quantity) VALUES
-- order 1: products 1-5, qty 1 each
(1, 1, 1200.00, 1),
(2, 1, 800.00, 1),
(3, 1, 150.00, 1),
(4, 1, 60.00, 1),
(5, 1, 100.00, 1),
-- order 2: products 6-10, qty 1 each
(6, 2, 45.00, 1),
(7, 2, 15.00, 1),
(8, 2, 35.00, 1),
(9, 2, 70.00, 1),
(10, 2, 300.00, 1),
-- order 3: products 1,3,5,7,9, qty 2 each
(1, 3, 1200.00, 2),
(3, 3, 150.00, 2),
(5, 3, 100.00, 2),
(7, 3, 15.00, 2),
(9, 3, 70.00, 2);