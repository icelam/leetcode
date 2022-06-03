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
  public boolean validateBST(TreeNode root, TreeNode low, TreeNode high) {
    if (root == null) {
      return true;
    }

    if ((low != null && root.val <= low.val) || (high != null && root.val >= high.val)) {
      return false;
    }

    return validateBST(root.left, low, root) && validateBST(root.right, root, high);
  }

  public boolean isValidBST(TreeNode root) {
    return validateBST(root, null, null);
  }
}
