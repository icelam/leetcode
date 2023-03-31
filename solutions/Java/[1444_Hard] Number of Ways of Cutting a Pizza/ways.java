class Solution {
  private static final int MOD = 1000000007;

  public int ways(String[] pizza, int k) {
    int height = pizza.length;
    int width = pizza[0].length();
    int[][][] dp  = new int[k + 1][height][width];
    int[][] appleCounts = new int[height + 1][width + 1];
    char[][] matrix = new char[height][];

    for (int r = 0; r < height; ++r) {
      matrix[r] = pizza[r].toCharArray();
    }

    for (int row = height - 1; row >= 0; row--) {
      for (int column = width - 1; column >= 0; column--) {
        // Upper left corner of the current section
        appleCounts[row][column] += matrix[row][column] == 'A' ? 1 : 0;
        // Cut horizontally, cut vertically, overlap in the middle
        appleCounts[row][column] += appleCounts[row][column + 1] + appleCounts[row + 1][column] - appleCounts[row + 1][column + 1];
      }
    }
    return dp(dp, appleCounts, height, width, 0, 0, k);
  }

  private int dp(int[][][] dp, int[][] appleCounts, int height, int width, int row, int column, int piecesNeeded) {
    if (piecesNeeded == 1) {
      dp[piecesNeeded][row][column] = appleCounts[row][column] > 0 ? 1 : 0;
      return dp[piecesNeeded][row][column];
    }

    if (dp[piecesNeeded][row][column] > 0) {
      return dp[piecesNeeded][row][column];
    }

    // Horizontal cut
    for (int i = row + 1; i < height; i++) {
      // Determine whether the cut part (upper part) contains at least 1 apple
      if (appleCounts[row][column] > appleCounts[i][column]) {
        dp[piecesNeeded][row][column] += dp(dp, appleCounts, height, width, i, column, piecesNeeded - 1);
        dp[piecesNeeded][row][column] %= MOD;
      }
    }

    // Vertical cut
    for (int j = column + 1; j < width; j++) {
      // Determine whether the cut part (left part) contains at least 1 apple
      if (appleCounts[row][column] > appleCounts[row][j]) {
        dp[piecesNeeded][row][column] += dp(dp, appleCounts, height, width, row, j, piecesNeeded - 1);
        dp[piecesNeeded][row][column] %= MOD;
      }
    }

    return dp[piecesNeeded][row][column];
  }
}
