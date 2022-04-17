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
  private void inOrder(TreeNode root, Queue queue) {
    if (root != null) {
      inOrder(root.left, queue);
      queue.add(root);
      inOrder(root.right, queue);
    }
  }

  public TreeNode increasingBST(TreeNode root) {
    if (root == null) {
      return root;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    inOrder(root, queue);

    TreeNode head = queue.remove();
    TreeNode current = head;

    while (current != null) {
      TreeNode next = queue.size() > 0 ? queue.remove() : null;
      current.left = null;
      current.right = next;
      current = next;
    }

    return head;
  }
}
