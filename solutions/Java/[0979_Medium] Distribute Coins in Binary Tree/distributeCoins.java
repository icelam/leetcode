class Solution {
  private int result;

  private int[] dfs(TreeNode root) {
    if (root == null) {
      return new int[]{0, 0};
    }

    int[] leftNode = dfs(root.left);
    int[] rightNode = dfs(root.right);
    int totalCoins = leftNode[0] + rightNode[0] + root.val;
    int nodeCount = leftNode[1] + rightNode[1] + 1;
    result += Math.abs(totalCoins - nodeCount);
    return new int[]{totalCoins, nodeCount};
  }

  public int distributeCoins(TreeNode root) {
    result = 0;
    dfs(root);
    return result;
  }
}
