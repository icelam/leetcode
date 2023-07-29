class Solution {
  public double soupServings(int n) {
    int m = Math.min(200, (int) Math.ceil(n / 25.0));
    double[][] dp = new double[m + 1][m + 1];
    Arrays.fill(dp[0], 1);
    dp[0][0] = 0.5;

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= m; j++) {
        double a = dp[Math.max(i - 4, 0)][j];
        double b = dp[Math.max(i - 3, 0)][Math.max(j - 1, 0)];
        double c = dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)];
        double d = dp[Math.max(i - 1, 0)][Math.max(j - 3, 0)];
        dp[i][j] = (a + b + c + d) / 4;
      }
    }

    return dp[m][m];
  }
}

