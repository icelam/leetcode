class Solution {
  public boolean canCross(int[] stones) {
    int n = stones.length;
    boolean[][] dp = new boolean[n][n];
    dp[0][0] = true;

    for (int i = 1; i < n; i++) {
      // Try all previois stone
      for (int j = i - 1; j >= 0; j--) {
        // last jump distance
        int k = stones[i] - stones[j];

        if (k > j + 1) {
          break;
        }

        // Frog's next jump must be either k - 1, k, or k + 1 units.
        dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];

        // Reached last stone
        if (i == n - 1 && dp[i][k]) {
          return true;
        }
      }
    }

    return false;
  }
}
