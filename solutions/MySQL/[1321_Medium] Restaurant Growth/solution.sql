SELECT DISTINCT
  visited_on,
  sum_amount AS amount,
  ROUND(sum_amount / 7, 2) AS average_amount
FROM (
  SELECT
    visited_on,
    SUM(amount) OVER (ORDER BY visited_on RANGE BETWEEN INTERVAL '6' DAY PRECEDING AND CURRENT ROW) AS sum_amount
  FROM Customer
) MovingSum
WHERE DATEDIFF(visited_on, (SELECT MIN(visited_on) FROM Customer)) >= 6;
