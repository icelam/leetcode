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
  public void inOrder(TreeNode root, List<Integer> list) {
    if (root != null) {
      inOrder(root.left, list);

      if (root.left == null && root.right == null) {
        list.add(root.val);
      }

      inOrder(root.right, list);
    }
  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> list1 = new ArrayList<>();
    inOrder(root1, list1);

    List<Integer> list2 = new ArrayList<>();
    inOrder(root2, list2);

    return list1.equals(list2);
  }
}
