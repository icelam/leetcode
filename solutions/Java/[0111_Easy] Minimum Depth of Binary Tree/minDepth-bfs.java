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

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    Boolean isLeafReach = false;
    int depth = 0;

    while (!isLeafReach) {
      int batchSize = queue.size();
      depth++;

      for (int i = 0; i < batchSize && !isLeafReach; i++) {
        TreeNode current = queue.remove();

        if (current.left == null && current.right == null) {
          isLeafReach = true;
        }

        if (current.left != null) {
          queue.add(current.left);
        }

         if (current.right != null) {
          queue.add(current.right);
        }
      }
    }

    return depth;
  }
}
