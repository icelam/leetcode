class Solution {
  public int minPathSum(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int[][] dp = new int[height][width];
    dp[0][0] = grid[0][0];

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (row == 0 && column == 0) {
          continue;
        }

        if (row == 0) {
          dp[row][column] = dp[row][column - 1] + grid[row][column];
        } else if (column == 0) {
          dp[row][column] = dp[row - 1][column] + grid[row][column];
        } else {
          dp[row][column] = Math.min(dp[row - 1][column], dp[row][column - 1]) + grid[row][column];
        }
      }
    }

    return dp[height - 1][width - 1];
  }
}
