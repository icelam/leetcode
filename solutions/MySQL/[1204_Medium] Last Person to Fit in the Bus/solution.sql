SELECT person_name FROM (
  SELECT
    Queue.turn,
    Queue.person_id,
    Queue.person_name,
    Queue.weight,
    SUM(WeightInfo.weight) AS cumulative_weight
  FROM Queue
  INNER JOIN Queue AS WeightInfo ON WeightInfo.turn <= Queue.turn
  GROUP BY Queue.turn
  ORDER BY turn ASC
) AS CumulativeWeight
WHERE cumulative_weight <= 1000
ORDER BY cumulative_weight DESC
LIMIT 1;
