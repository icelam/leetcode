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
  public boolean findTarget(TreeNode root, int k) {
    HashSet<Integer> set = new HashSet<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();

      if (set.contains(k - node.val)) {
        return true;
      }

      set.add(node.val);

      if (node.left != null) {
        queue.add(node.left);
      }

      if (node.right != null) {
        queue.add(node.right);
      }
    }

    return false;
  }
}
