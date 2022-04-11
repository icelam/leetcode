SELECT
  Summary.request_at AS Day,
  ROUND(SUM(IF(Summary.cancelled = "Yes", 1, 0)) / COUNT(*), 2) AS "Cancellation Rate"
FROM (
  SELECT
    Trips.request_at,
    IF(Trips.status LIKE "cancelled%", "Yes", "No") AS cancelled
  FROM Trips
  LEFT JOIN Users Drivers ON Trips.driver_id = Drivers.users_id
  LEFT JOIN Users Clients ON Trips.client_id = Clients.users_id
  WHERE
    Trips.request_at BETWEEN "2013-10-01" AND "2013-10-03"
    AND Drivers.banned = "No"
    AND Clients.banned = "No"
) AS Summary
GROUP BY Summary.request_at;
