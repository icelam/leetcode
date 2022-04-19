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
  private TreeNode previous = null;
  private TreeNode node1 = null;
  private TreeNode node2 = null;

  public final void inOrder(TreeNode root) {
    if (root != null) {
      inOrder(root.left);

      if (previous != null && previous.val > root.val) {
        if (node1 == null) {
          node1 = previous;
        }
        node2 = root;
      }

      previous = root;

      inOrder(root.right);
    }
  }

  public void recoverTree(TreeNode root) {
    inOrder(root);

    int temp = node1.val;
    node1.val = node2.val;
    node2.val = temp;
  }
}
