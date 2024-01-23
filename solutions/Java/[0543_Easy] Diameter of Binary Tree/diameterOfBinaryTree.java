class Solution {
  private int result = 0;

  private int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftDepth = dfs(node.left);
    int rightDepth = dfs(node.right);
    result = Math.max(result, leftDepth + rightDepth);

    return Math.max(leftDepth, rightDepth) + 1;
  }

  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return result;
  }
}
