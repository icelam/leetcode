class Solution {
  private static int MOD = (int) (1e9 + 7);

  public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
    int length = group.length;
    int sum = 0;
    int[][] dp = new int[n + 1][minProfit + 1];
    dp[0][0] = 1;

    for (int i = 0; i < length; i++) {
      int currentGroup = group[i];
      int currentProfit = profit[i];

      for (int j = n; j >= currentGroup; j--) {
        for (int k = minProfit; k >= 0; k--) {
          dp[j][k] += dp[j - currentGroup][Math.max(k - currentProfit, 0)];

          if (dp[j][k] > MOD) {
            dp[j][k] %= MOD;
          }
        }
      }
    }

    for (int i = 0; i <= n; i++) {
      sum += dp[i][minProfit];
      sum %= MOD;
    }

    return sum;
  }
}
