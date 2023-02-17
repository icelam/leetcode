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
  private Integer previous;
  private int min;

  public final void inOrder(TreeNode root) {
    if (root != null) {
      inOrder(root.left);

      if (previous != null) {
        min = Math.min(min, root.val - previous);
      }

      previous = root.val;
      inOrder(root.right);
    }
  }

  public int minDiffInBST(TreeNode root) {
    min = Integer.MAX_VALUE;
    inOrder(root);
    return min;
  }
}
