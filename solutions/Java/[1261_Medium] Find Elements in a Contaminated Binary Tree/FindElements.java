class FindElements {
  private HashSet<Integer> visited;

  public FindElements(TreeNode root) {
    visited = new HashSet<>();
    dfs(root, 0);
  }

  private void dfs(TreeNode currentNode, int currentValue) {
    if (currentNode == null) {
      return;
    }

    visited.add(currentValue);
    dfs(currentNode.left, currentValue * 2 + 1);
    dfs(currentNode.right, currentValue * 2 + 2);
  }

  public boolean find(int target) {
    return visited.contains(target);
  }
}
