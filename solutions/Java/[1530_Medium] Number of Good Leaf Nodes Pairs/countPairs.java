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
class Pair {
  int[] depths;
  int count;

  public Pair(int[] depths, int count) {
    this.depths = depths;
    this.count = count;
  }
}

class Solution {
  public Pair dfs(TreeNode root, int distance) {
    int[] depths = new int[distance + 1];

    if (root.left == null && root.right == null) {
      depths[0] = 1;
      return new Pair(depths, 0);
    }

    int[] leftDepths = new int[distance + 1];
    int[] rightDepths = new int[distance + 1];
    int leftCount = 0;
    int rightCount = 0;

    if (root.left != null) {
      Pair leftPair = dfs(root.left, distance);
      leftDepths = leftPair.depths;
      leftCount = leftPair.count;
    }

    if (root.right != null) {
      Pair rightPair = dfs(root.right, distance);
      rightDepths = rightPair.depths;
      rightCount = rightPair.count;
    }

    for (int i = 0; i < distance; i++) {
      depths[i + 1] += leftDepths[i];
      depths[i + 1] += rightDepths[i];
    }

    int count = 0;

    for (int i = 0; i <= distance; i++) {
      for (int j = 0; j + i + 2 <= distance; j++) {
        count += leftDepths[i] * rightDepths[j];
      }
    }

    return new Pair(depths, count + leftCount + rightCount);
  }

  public int countPairs(TreeNode root, int distance) {
    Pair pair = dfs(root, distance);
    return pair.count;
  }
}
