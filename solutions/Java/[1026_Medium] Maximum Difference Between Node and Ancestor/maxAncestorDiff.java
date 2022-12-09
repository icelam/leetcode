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
  public int dfs(TreeNode root, int min, int max) {
    int newMin = Math.min(min, root.val);
    int newMax = Math.max(max, root.val);

    if (root.left == null && root.right == null) {
      return newMax - newMin;
    }

    int leftDifference = 0;
    int rightDifference = 0;

    if (root.left != null) {
      leftDifference = dfs(root.left, newMin, newMax);
    }

    if (root.right != null) {
      rightDifference = dfs(root.right, newMin, newMax);
    }

    return Math.max(leftDifference, rightDifference);
  }

  public int maxAncestorDiff(TreeNode root) {
    return dfs(root, root.val, root.val);
  }
}
