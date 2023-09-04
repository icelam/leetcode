SELECT
  Product.product_id,
  Sales.year AS first_year,
  Sales.quantity,
  Sales.price
FROM Sales
JOIN Product ON Product.product_id = Sales.product_id
WHERE (Sales.product_id, Sales.year) IN (
  SELECT product_id, MIN(year) FROM Sales GROUP BY product_id
);
