class Solution {
  private static int MOD = (int) (1e9 + 7);

  public int numWays(int steps, int arrLen) {
    // Step more than `steps / 2` will not be able to return to original place
    int maxStep = Math.min(steps / 2, arrLen - 1);
    int[][] dp = new int[steps + 1][maxStep + 1];
    dp[steps][0] = 1;

    for (int i = steps - 1; i >= 0; i--) {
      for (int j = 0; j <= maxStep; j++) {
        dp[i][j] = (dp[i][j] + dp[i + 1][j]) % MOD;

        if (j - 1 >= 0) {
          dp[i][j] = (dp[i][j] + dp[i + 1][j - 1]) % MOD;
        }

        if (j + 1 <= maxStep) {
          dp[i][j] = (dp[i][j] + dp[i + 1][j + 1]) % MOD;
        }
      }
    }

    return dp[0][0];
  }
}
