SELECT
  UnitsSold.product_id,
  ROUND(SUM(UnitsSold.units * Prices.price) / SUM(UnitsSold.units), 2) AS average_price
FROM Prices
LEFT JOIN UnitsSold ON
  (UnitsSold.product_id = Prices.product_id)
  AND (UnitsSold.purchase_date BETWEEN Prices.start_date AND Prices.end_date)
WHERE UnitsSold.units >= 0
GROUP BY UnitsSold.product_id;
