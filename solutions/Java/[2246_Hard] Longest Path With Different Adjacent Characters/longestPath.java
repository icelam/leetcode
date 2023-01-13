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
}

class Solution {
  private int result;

  private TreeNode buildTree(int[] edges, char[] labels) {
    int n = edges.length;
    TreeNode[] nodes = new TreeNode[n];
    nodes[0] = new TreeNode(0, labels[0]);

    for (int i = 1; i < n; i++) {
      int parent = edges[i];
      int child = i;

      if (nodes[parent] == null) {
        nodes[parent] = new TreeNode(parent, labels[parent]);
      }

      if (nodes[child] == null) {
        nodes[child] = new TreeNode(child, labels[child]);
      }

      nodes[parent].addChild(nodes[child]);
    }

    return nodes[0];
  }

  public int dfs(TreeNode root, char previousLabel) {
    int longest = 0;
    int secondLongest = 0;

    for (TreeNode child: root.getChildren()) {
      int newPathLength = dfs(child, root.getLabel());

      if (root.getLabel() == child.getLabel()) {
        continue;
      }

      if (newPathLength > longest) {
        secondLongest = longest;
        longest = newPathLength;
      } else if (newPathLength > secondLongest) {
        secondLongest = newPathLength;
      }
    }

    result = Math.max(result, longest + secondLongest + 1);
    return longest + 1;
  }

  public int longestPath(int[] parent, String s) {
    result = 0;

    TreeNode root = buildTree(parent, s.toCharArray());
    dfs(root, ' ');

    return result;
  }
}
