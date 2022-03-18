SELECT Forecast.id FROM Weather, Weather Forecast
WHERE
  DATEDIFF(Weather.recordDate, Forecast.recordDate) = -1
  AND Forecast.temperature > Weather.temperature;
