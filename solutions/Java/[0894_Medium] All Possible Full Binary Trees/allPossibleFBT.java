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
  public List<TreeNode> allPossibleFBT(int n) {
    List<TreeNode> result = new ArrayList<>();

    if (n % 2 == 0) {
      return result;
    }

    if (n == 1) {
      result.add(new TreeNode(0));
      return result;
    }

    for (int i = 1; i < n; i += 2) {
      List<TreeNode> leftSubtrees = allPossibleFBT(i);
      List<TreeNode> rightSubtrees = allPossibleFBT(n - i - 1);

      for (TreeNode leftSubtree : leftSubtrees) {
        for (TreeNode rightSubtree : rightSubtrees) {
          TreeNode root = new TreeNode(0, leftSubtree, rightSubtree);
          result.add(root);
        }
      }
    }

    return result;
  }
}
