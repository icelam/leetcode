/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
  private HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> map;

  private void dfs(TreeNode root, int row, int column) {
    if (root == null) {
      return;
    }

    if (!map.containsKey(column)) {
      map.put(column, new HashMap<>());
    }

    HashMap<Integer, ArrayList<Integer>> columnMap = map.get(column);

    if (!columnMap.containsKey(row)) {
      columnMap.put(row, new ArrayList<>());
    }

    ArrayList<Integer> rowList = columnMap.get(row);
    rowList.add(root.val);

    if (root.left != null) {
      dfs(root.left, row + 1, column - 1);
    }

    if (root.right != null) {
      dfs(root.right, row + 1, column + 1);
    }
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    map = new HashMap<>();
    dfs(root, 0, 0);

    List<List<Integer>> result = new ArrayList<>();

    ArrayList<Integer> columnKeys = new ArrayList<>(map.keySet());
    Collections.sort(columnKeys);

    for (int column: columnKeys) {
      List<Integer> batch = new ArrayList<>();

      HashMap<Integer, ArrayList<Integer>> columnMap = map.get(column);
      ArrayList<Integer> rowKeys = new ArrayList<>(columnMap.keySet());
      Collections.sort(rowKeys);

      for (int row: rowKeys) {
        ArrayList<Integer> rowList = columnMap.get(row);
        Collections.sort(rowList);
        batch.addAll(rowList);
      }

      result.add(batch);
    }

    return result;
  }
}
