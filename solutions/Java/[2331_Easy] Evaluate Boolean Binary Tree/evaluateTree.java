class Solution {
  public boolean evaluateTree(TreeNode root) {
    if (root.val == 2) {
      return evaluateTree(root.left) || evaluateTree(root.right);
    }

    if (root.val == 3) {
      return evaluateTree(root.left) && evaluateTree(root.right);
    }

    return root.val == 1;
  }
}
