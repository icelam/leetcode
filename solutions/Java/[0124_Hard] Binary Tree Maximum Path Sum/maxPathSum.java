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
  private int result;

  public int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftMaxSum = root.val + dfs(root.left);
    result = Math.max(result, leftMaxSum);

    int rightMaxSum = root.val + dfs(root.right);
    result = Math.max(result, rightMaxSum);

    int maxSum = (leftMaxSum + rightMaxSum) - root.val;
    result = Math.max(result, maxSum);

    return Math.max(leftMaxSum > 0 ? leftMaxSum : 0, rightMaxSum > 0 ? rightMaxSum : 0);
  }

  public int maxPathSum(TreeNode root) {
    result = Integer.MIN_VALUE;
    dfs(root);
    return result;
  }
}
