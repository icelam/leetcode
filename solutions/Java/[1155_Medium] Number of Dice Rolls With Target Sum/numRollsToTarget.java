class Solution {
  private static final int MOD = (int) 1e9 + 7;
  private int[][] dp;

  private int count(int n, int k, int target) {
    if (n < 0 || target < 0) {
      return 0;
    }

    if (n == 0 && target == 0) {
      return 1;
    }

    if (dp[n][target] != -1) {
      return dp[n][target];
    }

    int result = 0;

    for (int i = 1; i <= k; i++) {
      result += count(n - 1, k, target - i);
      result %= MOD;
    }

    dp[n][target] = result;

    return result;
  }

  public int numRollsToTarget(int n, int k, int target) {
    dp = new int[n + 1][target + 1];

    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], -1);
    }

    return count(n, k, target);
  }
}
