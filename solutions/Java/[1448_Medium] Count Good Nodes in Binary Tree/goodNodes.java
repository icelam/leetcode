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
  private int result = 0;

  public void dfs(TreeNode root, int maxValue) {
    if (root.val >= maxValue) {
      result++;
    }

    if (root.left != null) {
      dfs(root.left, Math.max(maxValue, root.left.val));
    }

    if (root.right != null) {
      dfs(root.right, Math.max(maxValue, root.right.val));
    }
  }

  public int goodNodes(TreeNode root) {
    dfs(root, root.val);
    return result;
  }
}
