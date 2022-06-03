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
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    if (root != null) {
      queue.add(root);
    }

    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      List<Integer> levelList = new ArrayList<>();

      for (int i = 1; i <= queueSize; i++) {
        TreeNode current = queue.remove();
        levelList.add(current.val);

        if (current.left != null) {
          queue.add(current.left);
        }

        if (current.right != null) {
          queue.add(current.right);
        }
      }

      list.add(levelList);
    }

    return list;
  }
}
