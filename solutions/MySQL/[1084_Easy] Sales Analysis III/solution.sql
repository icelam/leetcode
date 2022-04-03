SELECT Product.product_id, Product.product_name FROM Product
WHERE Product.product_id NOT IN (
  SELECT Sales.product_id FROM Sales
  WHERE Sales.sale_date NOT BETWEEN "2019-01-01" AND "2019-03-31"
);
