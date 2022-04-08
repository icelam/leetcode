SELECT
  stock_name,
  SUM(IF(operation = "Sell", price, price * -1)) AS capital_gain_loss
FROM Stocks
GROUP BY stock_name;
