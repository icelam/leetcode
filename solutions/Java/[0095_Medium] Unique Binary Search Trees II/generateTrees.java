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
  public List<TreeNode> generateBST(int start, int end) {
    List<TreeNode> result = new ArrayList<>();

    if (start > end) {
      result.add(null);
      return result;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> leftTrees = generateBST(start, i - 1);
      List<TreeNode> rightTrees = generateBST(i + 1, end);

      for (TreeNode leftSubtree : leftTrees) {
        for (TreeNode rightSubtree : rightTrees) {
          TreeNode node = new TreeNode(i);
          node.left = leftSubtree;
          node.right = rightSubtree;
          result.add(node);
        }
      }
    }

    return result;
  }

  public List<TreeNode> generateTrees(int n) {
    return generateBST(1, n);
  }
}
