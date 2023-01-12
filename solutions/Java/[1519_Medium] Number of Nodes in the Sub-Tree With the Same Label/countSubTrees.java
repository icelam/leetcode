class TreeNode {
  private int value;
  private List<TreeNode> children;
  private char label;

  TreeNode(int value, char label) {
    this.value = value;
    this.children = new ArrayList<TreeNode>();
    this.label = label;
  }

  public void addChild(TreeNode child) {
    this.children.add(child);
  }

  public List<TreeNode> getChildren() {
    return this.children;
  }

  public char getLabel() {
    return this.label;
  }

  public int getValue() {
    return this.value;
  }
}

class Solution {
  private TreeNode[] buildTree(int n, int[][] edges, char[] labels) {
    TreeNode[] nodes = new TreeNode[n];
    for (int[] e: edges) {
      int parent = e[0] < e[1] ? e[0] : e[1];
      int child = e[0] < e[1] ? e[1] : e[0];

      if (nodes[parent] == null && nodes[child] != null) {
        int temp = parent;
        parent = child;
        child = temp;
      }

      if (nodes[parent] == null) {
        nodes[parent] = new TreeNode(parent, labels[parent]);
      }

      if (nodes[child] == null) {
        nodes[child] = new TreeNode(child, labels[child]);
      }

      nodes[parent].addChild(nodes[child]);
    }

    return nodes;
  }

  public int[] dfs(TreeNode root, int[] result) {
    int[] currentFrequency = new int[26];
    currentFrequency[root.getLabel() - 'a']++;

    for (TreeNode child: root.getChildren()) {
      int[] childFrequencies = dfs(child, result);

      for (int i = 0; i < 26; i++) {
        currentFrequency[i] += childFrequencies[i];
      }
    }

    result[root.getValue()] = currentFrequency[root.getLabel() - 'a'];

    return currentFrequency;
  }

  public int[] countSubTrees(int n, int[][] edges, String labels) {
    TreeNode[] nodes = buildTree(n, edges, labels.toCharArray());
    int[] result = new int[n];
    dfs(nodes[0], result);
    return result;
  }
}
