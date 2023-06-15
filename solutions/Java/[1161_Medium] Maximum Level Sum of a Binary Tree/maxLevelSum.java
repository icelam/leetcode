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
  public int maxLevelSum(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    int maxSum = Integer.MIN_VALUE;
    int maxLevel = 0;
    int currentLevel = 0;

    while (!queue.isEmpty()) {
      currentLevel++;
      int batchSize = queue.size();
      int levelSum = 0;

      for (int i = 0; i < batchSize; i++) {
        TreeNode currentNode = queue.remove();
        levelSum += currentNode.val;

        if (currentNode.left != null) {
          queue.add(currentNode.left);
        }

        if (currentNode.right != null) {
          queue.add(currentNode.right);
        }
      }

      if (levelSum > maxSum) {
        maxSum = levelSum;
        maxLevel = currentLevel;
      }
    }

    return maxLevel;
  }
}
