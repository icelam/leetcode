SELECT
  ROUND(
    COUNT(Activity.player_id) / (SELECT COUNT(DISTINCT UserCount.player_id) FROM Activity UserCount),
    2
  ) AS fraction
FROM Activity
WHERE (Activity.player_id, DATE_SUB(Activity.event_date, INTERVAL 1 DAY)) IN (
  SELECT
    FirstLogin.player_id,
    MIN(FirstLogin.event_date)
  FROM Activity FirstLogin
  GROUP BY FirstLogin.player_id
);
