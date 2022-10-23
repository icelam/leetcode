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
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftDepth = 1 + minDepth(root.left);
    int rightDepth = 1 + minDepth(root.right);

    if (root.left == null || root.right == null) {
      return root.left == null ? rightDepth : leftDepth;
    }

    return Math.min(leftDepth, rightDepth);
  }
}
