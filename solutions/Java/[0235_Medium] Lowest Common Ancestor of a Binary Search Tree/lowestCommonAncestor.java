/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
  private TreeNode lca;

  public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return false;
    }

    boolean isRootPQ = root.val == p.val || root.val == q.val;
    boolean isLeftSubtreeContainsPQ = dfs(root.left, p, q);
    boolean isRightSubtreeContainsPQ = dfs(root.right, p, q);

    /**
     * A lowest common ancestor of two nodes have 3 out of 2 characteristic below:
     * 1. The node itself is p or q
     * 2. The left subtree of the node has either p or q
     * 3. The right subtree of the node has either p or q
     *
     * A LCA can be determine by the below 2 case:
     * 1. When charaistic 1 is true, either charaistic 2 or 3 must be true
     * 2. When charactistic 1 is false, charaistic 2 AND 3 must be true
     */
    if (
      isRootPQ && (isLeftSubtreeContainsPQ || isRightSubtreeContainsPQ)
      || isLeftSubtreeContainsPQ && isRightSubtreeContainsPQ
    ) {
       lca = root;
    }

    return isLeftSubtreeContainsPQ || isRightSubtreeContainsPQ || isRootPQ;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    dfs(root, p, q);
    return lca;
  }
}
