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
  private TreeNode constructTree(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }

    int length = end - start + 1;
    int rootIndex = length / 2 + start;

    TreeNode root = new TreeNode(nums[rootIndex]);
    root.left = constructTree(nums, start, rootIndex - 1);
      root.right = constructTree(nums, rootIndex + 1, end);

    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return constructTree(nums, 0, nums.length - 1);
  }
}
