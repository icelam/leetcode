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
  public final void inOrder(TreeNode root, List<Integer> nodes, int k) {
    if (root != null && nodes.size() < k) {
      inOrder(root.left, nodes, k);
      nodes.add(root.val);
      inOrder(root.right, nodes, k);
    }
  }

  public int kthSmallest(TreeNode root, int k) {
    List<Integer> nodes = new ArrayList<>();
    inOrder(root, nodes, k);

    return nodes.get(k - 1);
  }
}
