class Solution {
  private void dfs(TreeNode root, List<String> result, String path) {
    if (root == null) {
      return;
    }

    StringBuilder builder = new StringBuilder();

    if (path.length() > 0) {
      builder.append(path);
      builder.append("->");
    }

    builder.append(root.val);

    String newPath = builder.toString();

    if (root.left == null && root.right == null) {
      result.add(newPath);
      return;
    }

    if (root.left != null) {
      dfs(root.left, result, newPath);
    }

    if (root.right != null) {
      dfs(root.right, result, newPath);
    }
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    dfs(root, result, "");
    return result;
  }
}
