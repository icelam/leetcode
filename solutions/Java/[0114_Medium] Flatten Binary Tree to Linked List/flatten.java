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
  private Queue<TreeNode> queue;

  public void preorederTraversal(TreeNode root) {
    if (root != null) {
      queue.offer(root);
      preorederTraversal(root.left);
      preorederTraversal(root.right);
    }
  }

  public void flatten(TreeNode root) {
    queue = new LinkedList<TreeNode>();
    preorederTraversal(root);

    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();
      current.left = null;
      current.right = queue.isEmpty() ? null : queue.peek();
    }
  }
}
