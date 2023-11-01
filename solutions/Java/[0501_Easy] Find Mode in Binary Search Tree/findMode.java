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
  private int previousVal;
  private int count;
  private int maxCount;

  public void inOrder(TreeNode node, List<Integer> mode) {
    if (node == null) {
      return;
    }

    inOrder(node.left, mode);

    if (node.val != previousVal) {
      count = 0;
      previousVal = node.val;
    }

    count++;

    if (count > maxCount) {
      mode.clear();
      maxCount = count;
    }

    if (count == maxCount) {
      mode.add(node.val);
    }

    inOrder(node.right, mode);
  }

  public int[] findMode(TreeNode root) {
    previousVal = 0;
    count = 0;
    maxCount = 0;
    List<Integer> mode = new ArrayList<>();
    inOrder(root, mode);

    int[] result = new int[mode.size()];

    for (int i = 0; i < result.length; i++) {
      result[i] = mode.get(i);
    }

    return result;
  }
}
