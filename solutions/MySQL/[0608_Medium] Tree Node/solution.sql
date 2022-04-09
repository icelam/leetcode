SELECT
  Tree.id,
  IF(
    Tree.p_id IS NULL,
    "Root",
    IF(
      Tree.id IN (SELECT Tree.p_id FROM Tree WHERE Tree.p_id IS NOT NULL),
      "Inner",
      "Leaf"
    )
  ) AS type
FROM Tree;
