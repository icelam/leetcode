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
  public int deepestLeavesSum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int result = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      int levelSum = 0;

      for (int i = 1; i <= queueSize; i++) {
        TreeNode current = queue.remove();
        levelSum += current.val;

        if (current.left != null) {
          queue.add(current.left);
        }

        if (current.right != null) {
          queue.add(current.right);
        }
      }

      result = levelSum;
    }

    return result;
  }
}
