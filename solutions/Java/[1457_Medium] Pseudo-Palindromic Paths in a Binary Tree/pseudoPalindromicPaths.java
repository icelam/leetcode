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
  private int result;

  public void dfs(TreeNode root, int[] counts) {
    if (root.left == null && root.right == null) {
      int oddAppearance = 0;

      for (int c: counts) {
        oddAppearance += c % 2;
      }

      if (oddAppearance <= 1) {
        result++;
      }
    }

    if (root.left != null) {
      counts[root.left.val]++;
      dfs(root.left, counts);
      counts[root.left.val]--;
    }

    if (root.right != null) {
      counts[root.right.val]++;
      dfs(root.right, counts);
      counts[root.right.val]--;
    }
  }

  public int pseudoPalindromicPaths(TreeNode root) {
    result = 0;
    int[] counts = new int[10];
    counts[root.val]++;

    dfs(root, counts);
    return result;
  }
}
