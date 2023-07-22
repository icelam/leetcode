class Solution {
  private int[][] directions = {
    {-1, -2},
    {-2, -1},
    {-2, 1},
    {-1, 2},
    {1, 2},
    {2, 1},
    {2, -1},
    {1, -2}
  };

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public double knightProbability(int n, int k, int row, int column) {
    double[][][] dp = new double[k + 1][n][n];

    // Original state = 1 possible move = did  not move
    dp[0][row][column] = 1;

    // K-step
    for (int i = 1; i <= k; i++) {
      // Each of the cell we try all 8 possible moves
      for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
          for (int[] d : directions) {
            int newY = y + d[0];
            int newX = x + d[1];

            if (!isValidPosition(newY, newX, n, n)) {
              continue;
            }

            dp[i][y][x] += dp[i - 1][newY][newX];
          }
        }
      }
    }

    // Calculate possibility
    double sum = 0;
    for (double[] r : dp[k]) {
      for (double c : r) {
        sum += c;
      }
    }
    return sum / Math.pow(8, k);
  }
}
