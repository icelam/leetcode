SELECT
  (CASE
    WHEN LEAD(Seat.id, 1) OVER() IS NULL AND MOD(Seat.id, 2) = 1
      THEN Seat.id
    WHEN MOD(Seat.id, 2) = 0
      THEN Seat.id - 1
    ELSE id + 1
  END) AS id,
  Seat.student
FROM
  Seat
ORDER BY id ASC;
