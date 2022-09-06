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
  private int sumAndPrune(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftSum = sumAndPrune(root.left);
    int rightSum = sumAndPrune(root.right);

    if (leftSum == 0) {
      root.left = null;
    }

    if (rightSum == 0) {
      root.right = null;
    }

    return root.val + leftSum + rightSum;
  }

  public TreeNode pruneTree(TreeNode root) {
    TreeNode dummyRoot = new TreeNode(1, root, null);
    sumAndPrune(dummyRoot);
    return dummyRoot.left;
  }
}
