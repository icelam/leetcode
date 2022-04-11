SELECT ConsecutiveDate.id, ConsecutiveDate.visit_date, ConsecutiveDate.people FROM (
  SELECT
    Stadium.id,
    Stadium.visit_date,
    Stadium.people,
    (CASE
      WHEN Stadium.people >= 100
        THEN (CASE
          WHEN LEAD(Stadium.people, 1) OVER () >= 100 AND LEAD(Stadium.people, 2) OVER () >= 100
            THEN TRUE
          WHEN LAG(Stadium.people, 1) OVER () >= 100 AND LAG(Stadium.people, 2) OVER () >= 100
            THEN TRUE
          WHEN LAG(Stadium.people, 1) OVER () >= 100 AND LEAD(Stadium.people, 1) OVER () >= 100
            THEN TRUE
          ELSE FALSE
        END)
      ELSE FALSE
    END) AS is_consecutive
  FROM Stadium
) AS ConsecutiveDate
WHERE ConsecutiveDate.is_consecutive = TRUE;
