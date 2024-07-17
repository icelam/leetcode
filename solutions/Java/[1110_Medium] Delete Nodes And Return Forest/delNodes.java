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
  private TreeNode postorder(TreeNode root, HashSet<Integer> nodesToDelete, List<TreeNode> forest) {
    if (root == null) {
      return null;
    }

    root.left = postorder(root.left, nodesToDelete, forest);
    root.right = postorder(root.right, nodesToDelete, forest);

    if (nodesToDelete.contains(root.val)) {
      if (root.left != null) {
        forest.add(root.left);
      }

      if (root.right != null) {
        forest.add(root.right);
      }

      return null;
    }

    return root;
  }

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    HashSet<Integer> nodesToDelete = new HashSet<>();

    for (int node: to_delete) {
      nodesToDelete.add(node);
    }

    List<TreeNode> forest = new ArrayList<>();

    root = postorder(root, nodesToDelete, forest);

    if (root != null) {
      forest.add(root);
    }

    return forest;
  }
}
