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
  private int count;
  private HashSet<TreeNode> camerasCoverage;

  // Place a camera if:
  // 1. Node children do not have camera coverage
  // 3. Current node does not have parent and has no camera coverage
  // After placing a camera, add 1 to count
  // Seach the binary tree from bottom to top
  public void dfs(TreeNode root, TreeNode parent) {
    if (root != null) {
      dfs(root.left, root);
      dfs(root.right, root);

      if (
        (root.left != null && !camerasCoverage.contains(root.left))
        || (root.right != null && !camerasCoverage.contains(root.right))
        || parent == null && !camerasCoverage.contains(root)
      ) {
        count++;

        if (root.left != null) {
          camerasCoverage.add(root.left);
        }

        if (root.right != null) {
          camerasCoverage.add(root.right);
        }

        if (parent != null) {
          camerasCoverage.add(parent);
        }

        camerasCoverage.add(root);
      }
    }
  }

  public int minCameraCover(TreeNode root) {
    count = 0;
    camerasCoverage = new HashSet<TreeNode>();
    dfs(root, null);
    return count;
  }
}
