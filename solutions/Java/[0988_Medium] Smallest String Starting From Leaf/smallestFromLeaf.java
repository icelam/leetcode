class Solution {
  private String result = "";

  private void dfs(TreeNode root, StringBuilder builder) {
    builder.insert(0, (char) (root.val + 'a'));
    String currentStr = builder.toString();

    if (
      (root.left == null && root.right == null)
      && (result.isEmpty() || currentStr.compareTo(result) < 0)
    ) {
      result = currentStr;
    }

    if (root.left != null) {
      dfs(root.left, builder);
    }

    if (root.right != null) {
      dfs(root.right, builder);
    }

    builder.deleteCharAt(0);
  }

  public String smallestFromLeaf(TreeNode root) {
    dfs(root, new StringBuilder());
    return result;
  }
}
