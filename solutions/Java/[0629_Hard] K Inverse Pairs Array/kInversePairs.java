class Solution {
  public int kInversePairs(int n, int k) {
    int[][] dp = new int[n + 1][k + 1];
    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      long sum = 0;

      for (int j = 0; j <= k; j++) {
        sum += dp[i - 1][j];

        if (j + 1 > i) {
          sum -= dp[i - 1][j - i];
        }

        dp[i][j] = (int) (sum % (1e9 + 7));
      }
    }

    return dp[n][k];
  }
}
