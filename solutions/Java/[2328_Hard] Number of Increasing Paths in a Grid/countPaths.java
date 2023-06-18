class Solution {
  private static int MOD = (int) (1e9 + 7);

  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private int[][] dp;

  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public int dfs(int[][] grid, int height, int width, int row, int column) {
    if (dp[row][column] != 0) {
      return dp[row][column];
    }

    int result = 1;
    for (int[] d : directions) {
      int previousRow = row + d[0];
      int previousColumn = column + d[1];

      if (
        isValidPosition(previousRow, previousColumn, height, width)
        && grid[previousRow][previousColumn] < grid[row][column]
      ) {
        result += dfs(grid, height, width, previousRow, previousColumn);
        result %= MOD;
      }
    }

    dp[row][column] = result;
    return result;
  }

  public int countPaths(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    dp = new int[height][width];

   int result = 0;

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        result = (result + dfs(grid, height, width, row, column)) % MOD;
      }
    }

    return result;
  }
}
