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
  private HashMap<String, Integer> map;
  private List<TreeNode> result;

  public String dfs(TreeNode root) {
    if (root == null) {
      return "null";
    }

    StringBuilder builder = new StringBuilder();
    builder
      .append(root.val)
      .append("->(L)")
      .append(dfs(root.left))
      .append("->(R)")
      .append(dfs(root.right));

    String key = builder.toString();
    map.put(key, map.getOrDefault(key, 0) + 1);

    if (map.get(key) == 2) {
      result.add(root);
    }

    return key;
  }
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    map = new HashMap<>();
    result = new ArrayList<>();
    dfs(root);
    return result;
  }
}
