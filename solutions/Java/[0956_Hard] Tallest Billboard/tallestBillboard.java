class Solution {
  public int tallestBillboard(int[] rods) {
    int n = rods.length;
    int sum = 0;

    for (int rodLength: rods) {
      sum += rodLength;
    }

    int[][] dp = new int[n + 1][sum + 1];
    for (int[] row: dp) {
      Arrays.fill(row, Integer.MIN_VALUE);
    }
    dp[0][0] = 0;

    for (int i = 1; i <= n; i++) {
      int length = rods[i - 1];

      for (int j = 0; j <= sum; j++) {
        // 1. Do not use current rod
        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

        if (j + length <= sum) {
          // 2. Add to larger stack, smaller stack stay unchanged
          dp[i][j + length] = Math.max(dp[i][j + length], dp[i - 1][j]);
        }

        if (j >= length) {
          // 3. Add to smaller stack but not exceed current larger stack
          dp[i][j - length] = Math.max(dp[i][j - length], dp[i - 1][j] + length);
        }

        if (length >= j) {
          // 4. Add to smaller stack and become larger than the current larger stack
          dp[i][length - j] = Math.max(dp[i][length - j], dp[i - 1][j] + j);
        }
      }
    }

    return dp[n][0];
  }
}
