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
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (queue.size() > 0) {
      int batchSize = queue.size();

      for (int i = 1; i <= batchSize; i++) {
        TreeNode current = queue.remove();

        if (current.left != null) {
          queue.add(current.left);
        }

        if (current.right != null) {
          queue.add(current.right);
        }

        if (i == batchSize) {
          result.add(current.val);
        }
      }
    }

    return result;
  }
}
