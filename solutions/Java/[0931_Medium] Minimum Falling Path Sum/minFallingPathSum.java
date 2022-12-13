class Solution {
  public int minFallingPathSum(int[][] matrix) {
    int size = matrix.length;

    int[][] dp = new int[size][size];

    for (int i = 0; i < size; i++) {
      dp[0][i] = matrix[0][i];
    }

    for (int row = 1; row < size; row++) {
      for (int column = 0; column < size; column++) {
        int min = dp[row - 1][column];

        if (column < size - 1) {
          min = Math.min(dp[row - 1][column + 1], min);
        }

        if (column > 0) {
          min = Math.min(dp[row - 1][column - 1], min);
        }

        dp[row][column] = min + matrix[row][column];
      }
    }

    int result = Integer.MAX_VALUE;
    for (int n: dp[size - 1]) {
      result = Math.min(result, n);
    }

    return result;
  }
}
