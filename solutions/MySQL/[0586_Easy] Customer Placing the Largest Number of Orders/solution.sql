SELECT customer_number FROM Orders
GROUP BY customer_number HAVING COUNT(order_number) = (
  SELECT COUNT(order_number) AS max FROM Orders
  GROUP BY customer_number
  ORDER BY max DESC
  LIMIT 1
);
