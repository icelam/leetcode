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
  private List<List<Integer>> result;

  private void dfs(TreeNode root, int targetSum, int currentSum, List<Integer> path) {
    if (root.left == null && root.right == null) {
      if (currentSum == targetSum) {
        result.add(new ArrayList(path));
      }

      return;
    }

    if (root.left != null) {
      int leftValue = root.left.val;
      path.add(leftValue);
      currentSum += leftValue;
      dfs(root.left, targetSum, currentSum, path);
      path.remove(path.size() - 1);
      currentSum -= leftValue;
    }

    if (root.right != null) {
      int rightValue = root.right.val;
      path.add(rightValue);
      currentSum += rightValue;
      dfs(root.right, targetSum, currentSum, path);
      path.remove(path.size() - 1);
      currentSum -= rightValue;
    }
  }

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    int currentValue = root.val;
    List<Integer> path = new ArrayList<>();
    path.add(currentValue);
    dfs(root, targetSum, currentValue, path);

    return result;
  }
}
