SELECT
  ROUND(AVG((CASE
    WHEN Delivery.order_date = Delivery.customer_pref_delivery_date
      THEN 1
      ELSE 0
   END
  )) * 100, 2) AS immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) IN (
  SELECT
    customer_id,
    MIN(order_date)
  FROM Delivery
  GROUP BY customer_id
);
