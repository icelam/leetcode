class Solution {
  private static int[] directions = new int[]{-1, 0, 1};

  private boolean isValidColumn(int width, int column) {
    return column >= 0 && column < width;
  }

  private int dfs(int[][] grid, int height, int width, int row, int column1, int column2, int[][][] dp) {
    if (
      row == height
      || !isValidColumn(width, column1)
      || !isValidColumn(width, column2)
      || column1 == column2
    ) {
      return 0;
    }

    if (dp[row][column1][column2] != -1) {
      return dp[row][column1][column2];
    }

    int sum = 0;

    for (int d1 : directions) {
      for (int d2 : directions) {
        sum = Math.max(sum, dfs(grid, height, width, row + 1, column1 + d1, column2 + d2, dp));
      }
    }

    dp[row][column1][column2] = grid[row][column1] + grid[row][column2] + sum;
    return dp[row][column1][column2];
  }

  public int cherryPickup(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int[][][] dp = new int[height][width][width];

    for (int[][] row: dp) {
      for (int[] column: row) {
        Arrays.fill(column, -1);
      }
    }

    return dfs(grid, height, width, 0, 0, width - 1, dp);
  }
}
