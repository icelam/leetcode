class Solution {
  private static final int MAX_NODE = 100001;
  private int currentMaxHeight;
  private int[] maxHeight1;
  private int[] maxHeight2;

  private void dfs1(TreeNode root, int depth) {
    maxHeight1[root.val] = currentMaxHeight;
    currentMaxHeight = Math.max(currentMaxHeight, depth);

    if (root.left != null) {
      dfs1(root.left, depth + 1);
    }
    if (root.right != null) {
      dfs1(root.right, depth + 1);
    }
  }

  private void dfs2(TreeNode root, int depth) {
    maxHeight2[root.val] = currentMaxHeight;
    currentMaxHeight = Math.max(currentMaxHeight, depth);

    if (root.right != null) {
      dfs2(root.right, depth + 1);
    }
    if (root.left != null) {
      dfs2(root.left, depth + 1);
    }
  }

  public int[] treeQueries(TreeNode root, int[] queries) {
    currentMaxHeight = 0;
    maxHeight1 = new int[MAX_NODE];
    dfs1(root, 0);

    currentMaxHeight = 0;
    maxHeight2 = new int[MAX_NODE];
    dfs2(root, 0);

    int[] result = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      int queryNode = queries[i];
      result[i] = Math.max(maxHeight1[queryNode], maxHeight2[queryNode]);
    }

    return result;
  }
}

