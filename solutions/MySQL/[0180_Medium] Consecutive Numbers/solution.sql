SELECT DISTINCT ConsecutiveLogs.num AS ConsecutiveNums FROM (
  SELECT
    id,
    num,
    (CASE
      WHEN num = LAG(num, 1)  OVER () AND num = LAG(num, 2) OVER ()
        THEN TRUE
      ELSE FALSE
    END) AS streak_three
  FROM Logs
) AS ConsecutiveLogs
WHERE ConsecutiveLogs.streak_three = true;
