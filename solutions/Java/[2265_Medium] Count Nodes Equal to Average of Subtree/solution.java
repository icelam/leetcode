class Solution {
  private int result;

  private int[] dfs(TreeNode root) {
    if (root == null) {
      return new int[]{0, 0};
    }

    int[] leftInfo = dfs(root.left);
    int[] rightInfo = dfs(root.right);
    int[] currentInfo = new int[]{root.val + leftInfo[0] + rightInfo[0], 1 + leftInfo[1] + rightInfo[1]};

    if (currentInfo[0] / currentInfo[1] == root.val) {
      result++;
    }

    return currentInfo;
  }

  public int averageOfSubtree(TreeNode root) {
    result = 0;
    dfs(root);
    return result;
  }
}
