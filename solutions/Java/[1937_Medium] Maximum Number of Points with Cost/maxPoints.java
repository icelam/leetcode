class Solution {
  public long maxPoints(int[][] points) {
    int m = points.length;
    int n = points[0].length;
    long[] dp = new long[n];

    for (int i = 0; i < m; i++) {
      long[] currentRow = new long[n + 1];
      long leftMax = 0;

      for (int j = 0; j < n; j++) {
        leftMax = Math.max(leftMax - 1, dp[j]);
        currentRow[j] = leftMax;
      }

      long rightMax = 0;

      for (int j = n - 1; j >= 0; j--) {
        rightMax = Math.max(rightMax - 1, dp[j]);
        currentRow[j] = Math.max(currentRow[j], rightMax);
      }

      for (int j = 0; j < n; j++) {
        dp[j] = currentRow[j] + points[i][j];
      }
    }

    long result = 0;

    for (int j = 0; j < n; j++) {
      result = Math.max(result, dp[j]);
    }

    return result;
  }
}
