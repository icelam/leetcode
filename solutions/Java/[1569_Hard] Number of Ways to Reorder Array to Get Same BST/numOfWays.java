class Solution {
  private static int MOD = (int) (1e9 + 7);
  private int[][] combinations;

  public int[] dfs(TreeNode node) {
    if (node == null) {
      return new int[]{0, 1};
    }

    int[] left = dfs(node.left);
    int[] right = dfs(node.right);
    int size = left[0] + right[0] + 1;
    long numberOfWays = (long) combinations[left[0] + right[0]][left[0]] * left[1] % MOD * right[1] % MOD;
    return new int[]{size, (int) numberOfWays};
  }

  public void insertIntoBST(TreeNode root, int val) {
    TreeNode newNode = new TreeNode(val);
    TreeNode currentNode = root;
    TreeNode parentNode = null;

    while (currentNode != null) {
      parentNode = currentNode;
      currentNode = currentNode.val > val ? currentNode.left : currentNode.right;
    }

    if (parentNode.val > val) {
      parentNode.left = newNode;
    } else {
      parentNode.right = newNode;
    }
  }

  public int numOfWays(int[] nums) {
    int n = nums.length;
    combinations = new int[n + 1][n + 1];
    combinations[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      combinations[i][0] = 1;
      combinations[i][i] = 1;

      for (int j = 1; j < i; j++) {
        combinations[i][j] = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % MOD;
      }
    }

    TreeNode root = new TreeNode(nums[0]);

    for (int i = 1; i < n; i++) {
      insertIntoBST(root, nums[i]);
    }

    return (dfs(root)[1] - 1) % MOD;
  }
}
