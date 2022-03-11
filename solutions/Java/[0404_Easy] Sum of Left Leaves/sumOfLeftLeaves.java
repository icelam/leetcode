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
  public int sumOfLeftLeaves(TreeNode root) {
    Stack<TreeNode> stack = new Stack();
    stack.add(root);

    int sum = 0;

    while (stack.size() > 0) {
      TreeNode current = stack.pop();

      if (current.right != null) {
        stack.add(current.right);
      }

      if (current.left != null) {
        if (current.left.left == null && current.left.right == null) {
          sum += current.left.val;
        }
        stack.add(current.left);
      }
    }

    return sum;
  }
}
