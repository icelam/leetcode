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
  private int max;

  // previous: 0 = root, 1 = left, 2 = right
  private void dfs(TreeNode root, int previous, int length) {
    if (root == null) {
      return;
    }

    max = Math.max(max, length);

    dfs(root.left, 1, previous != 1 ? length + 1 : 1);
    dfs(root.right, 2, previous != 2 ? length + 1 : 1);
  }

  public int longestZigZag(TreeNode root) {
    max = 0;
    dfs(root, 0, 0);
    return max;
  }
}
