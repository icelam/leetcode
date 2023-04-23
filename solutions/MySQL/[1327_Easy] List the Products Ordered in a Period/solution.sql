SELECT DISTINCT(Products.product_name), SUM(Orders.unit) AS unit FROM Products
LEFT JOIN Orders ON Products.product_id = Orders.product_id
WHERE (Orders.order_date BETWEEN '2020-02-01' AND '2020-02-29')
GROUP BY Products.product_id
HAVING SUM(Orders.unit) >= 100;
