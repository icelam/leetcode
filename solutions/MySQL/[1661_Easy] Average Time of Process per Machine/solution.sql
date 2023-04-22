SELECT
  StartActivity.machine_id,
  ROUND(AVG(EndActivity.timestamp - StartActivity.timestamp), 3) AS processing_time
FROM Activity StartActivity
JOIN Activity EndActivity ON
  StartActivity.machine_id = EndActivity.machine_id
  AND StartActivity.process_id = EndActivity.process_id
  AND StartActivity.activity_type = 'start'
  AND EndActivity.activity_type = 'end'
GROUP BY StartActivity.machine_id;
