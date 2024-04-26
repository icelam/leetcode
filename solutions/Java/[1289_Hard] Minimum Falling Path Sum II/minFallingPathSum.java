class Solution {
  public int minFallingPathSum(int[][] grid) {
    int size = grid.length;

    int[][] dp = new int[size][size];

    for (int i = 0; i < size; i++) {
      dp[0][i] = grid[0][i];
    }

    for (int i = 1; i < size; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    for (int row = 1; row < size; row++) {
      for (int column = 0; column < size; column++) {
        for (int nextColumn = 0; nextColumn < size; nextColumn++) {
          if (column == nextColumn) {
            continue;
          }

          dp[row][column] = Math.min(dp[row][column], dp[row - 1][nextColumn] + grid[row][column]);
        }
      }
    }

    int result = Integer.MAX_VALUE;

    for (int n: dp[size - 1]) {
      result = Math.min(result, n);
    }

    return result;
  }
}
