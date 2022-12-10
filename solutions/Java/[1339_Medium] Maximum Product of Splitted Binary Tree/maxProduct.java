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
  private static int MOD = (int) (1e9 + 7);
  private long result;

  public long sumOfTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return root.val + sumOfTree(root.left) + sumOfTree(root.right);
  }

  public long maxTreeProduct(TreeNode root, long sum) {
    if (root == null) {
      return 0;
    }

    long leftTreeSum = maxTreeProduct(root.left, sum);
    long rightTreeSum = maxTreeProduct(root.right, sum);

    if (leftTreeSum != 0) {
      result = Math.max(result, (sum - leftTreeSum) * leftTreeSum);
    }

    if (rightTreeSum != 0) {
      result = Math.max(result, (sum - rightTreeSum) * rightTreeSum);
    }

    return leftTreeSum + rightTreeSum + root.val;
  }

  public int maxProduct(TreeNode root) {
    long treeSum = sumOfTree(root);
    maxTreeProduct(root, treeSum);
    return (int) (result % MOD);
  }
}
