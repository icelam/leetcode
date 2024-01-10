class Solution {
  private int result = 0;
  private int startDepth = -1;

  private int dfs(TreeNode root, int currentLevel, int start) {
    if (root == null) {
      return 0;
    }

    if (root.val == start) {
      startDepth = currentLevel;
    }

    int leftDepth = dfs(root.left, currentLevel + 1, start);
    boolean isStartInLeftSubtree = startDepth != -1;
    int rightDepth = dfs(root.right, currentLevel + 1, start);

    if (root.val == start) {
      result = Math.max(result, Math.max(leftDepth, rightDepth));
    } else if (isStartInLeftSubtree) {
      result = Math.max(result, startDepth - currentLevel + rightDepth);
    } else {
      result = Math.max(result, startDepth - currentLevel + leftDepth);
    }

    return Math.max(leftDepth, rightDepth) + 1;
  }

  public int amountOfTime(TreeNode root, int start) {
    dfs(root, 0, start);
    return result;
  }
}
