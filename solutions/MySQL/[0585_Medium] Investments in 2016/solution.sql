SELECT ROUND(SUM(tiv_2016),  2) AS tiv_2016 FROM (
  SELECT
    pid,
    tiv_2016,
    COUNT(*) OVER (PARTITION by tiv_2015) AS tiv_2015_count,
    COUNT(*) OVER (PARTITION by lat, lon) AS location_count
  FROM Insurance
) UniqueCount
WHERE tiv_2015_count >= 2 AND location_count = 1;
