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
  private TreeNode findLCA(TreeNode root, int p, int q) {
    if (root == null) {
      return null;
    }

    if (root.val == p || root.val == q) {
      return root;
    }

    TreeNode leftNode = findLCA(root.left, p, q);
    TreeNode rightNode = findLCA(root.right, p, q);

    if (leftNode != null && rightNode != null) {
      return root;
    }

    if (leftNode != null) {
      return leftNode;
    }

    return rightNode;
  }

  private boolean findPath(TreeNode root, int target, StringBuilder path) {
    if (root == null) {
      return false;
    }

    if (root.val == target) {
      return true;
    }

    path.append('L');

    if (findPath(root.left, target, path)) {
      return true;
    }

    path.deleteCharAt(path.length() - 1);
    path.append('R');

    if (findPath(root.right, target, path)) {
      return true;
    }

    path.deleteCharAt(path.length() - 1);

    return false;
  }

  public String getDirections(TreeNode root, int startValue, int destValue) {
    TreeNode lca = findLCA(root, startValue, destValue);

    StringBuilder pathToStart = new StringBuilder();
    StringBuilder pathToDestination = new StringBuilder();

    findPath(lca, startValue, pathToStart);
    findPath(lca, destValue, pathToDestination);

    for (int i = 0; i < pathToStart.length(); i++) {
      pathToDestination.insert(0, 'U');
    }

    return pathToDestination.toString();
  }
}
