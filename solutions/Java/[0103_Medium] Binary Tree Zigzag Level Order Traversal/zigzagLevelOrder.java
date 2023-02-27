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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();

    if (root == null) {
      return result;
    }

    int level = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int batchSize = queue.size();
      List<Integer> values = new LinkedList<>();

      for (int i = 0; i < batchSize; i++) {
        TreeNode currentNode = queue.remove();

        if (level % 2 == 0) {
          values.add(currentNode.val);
        } else {
          values.add(0, currentNode.val);
        }

        if (currentNode.left != null) {
          queue.add(currentNode.left);
        }

        if (currentNode.right != null) {
          queue.add(currentNode.right);
        }
      }

      result.add(values);
      level++;
    }

    return result;
  }
}
