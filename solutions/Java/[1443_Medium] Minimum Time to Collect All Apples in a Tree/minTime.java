class TreeNode {
  private int value;
  private List<TreeNode> children;
  private boolean hasApple;

  TreeNode(int value, boolean hasApple) {
    this.value = value;
    this.children = new ArrayList<TreeNode>();
    this.hasApple = hasApple;
  }

  public void addChild(TreeNode child) {
    this.children.add(child);
  }

  public int getNumberOfChildren() {
    return this.children.size();
  }

  public List<TreeNode> getChildren() {
    return this.children;
  }

  public boolean isHavingApple() {
    return this.hasApple;
  }
}

class Solution {
  private TreeNode buildTree(int n, int[][] edges, List<Boolean> hasApple) {
    TreeNode[] nodes = new TreeNode[n];

    for (int[] e: edges) {
      int parent = e[0];
      int child = e[1];

      if (nodes[parent] == null && nodes[child] != null) {
        parent = child;
        child = e[0];
      }

      if (nodes[parent] == null) {
        nodes[parent] = new TreeNode(parent, hasApple.get(parent));
      }

      if (nodes[child] == null) {
        nodes[child] = new TreeNode(child, hasApple.get(child));
      }

      nodes[parent].addChild(nodes[child]);
    }

    return nodes[0];
  }

  public int dfs(TreeNode root) {
    int nodesToTravel = 0;

    for (TreeNode child: root.getChildren()) {
      nodesToTravel += dfs(child);
    }

    if (root.isHavingApple() || nodesToTravel > 0) {
      nodesToTravel++;
    }

    return nodesToTravel;
  }

  public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    TreeNode root = buildTree(n, edges, hasApple);

    int edgesToTravel = dfs(root) - 1;
    return edgesToTravel > 0 ? edgesToTravel * 2 : 0;
  }
}
