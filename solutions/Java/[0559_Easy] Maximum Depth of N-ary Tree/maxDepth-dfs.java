class Solution {
  public int dfs(Node root) {
    if (root == null) {
      return 0;
    }

    int depth = 0;

    for (Node child: root.children) {
      depth = Math.max(depth, dfs(child));
    }

    return depth + 1;
  }

  public int maxDepth(Node root) {
    return dfs(root);
  }
}
