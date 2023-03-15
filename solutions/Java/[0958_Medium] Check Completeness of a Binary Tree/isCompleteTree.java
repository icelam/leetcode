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
  public boolean isCompleteTree(TreeNode root) {
    TreeNode previousNode = new TreeNode();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()) {
      for (int i = queue.size(); i > 0; i--) {
        TreeNode currentNode = queue.remove();

        if (currentNode == null && queue.peek() != null) {
          return false;
        }

        if (currentNode != null) {
          queue.add(currentNode.left);
          queue.add(currentNode.right);
        }
      }
    }

    return true;
  }
}
