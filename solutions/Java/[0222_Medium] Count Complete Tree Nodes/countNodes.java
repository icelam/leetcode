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
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    TreeNode leftNode = root.left;
    TreeNode rightNode = root.right;
    int leftCount = 0;
    int rightCount = 0;

    while (leftNode != null) {
      leftNode = leftNode.left;
      leftCount++;
    }

    while (rightNode != null) {
      rightNode = rightNode.right;
      rightCount++;
    }

    if (leftCount == rightCount) {
      return (int) Math.pow(2, leftCount + 1) - 1;
    }

    return countNodes(root.left) + countNodes(root.right) + 1;
  }
}
