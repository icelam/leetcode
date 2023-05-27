class Solution {
  public String stoneGameIII(int[] stoneValue) {
    int n = stoneValue.length;
    int[] dp = new int[n + 3];
    int sum = 0;

    for (int i = n - 1; i >= 0; i--) {
      dp[i] = Integer.MIN_VALUE;
      sum += stoneValue[i];

      for (int j = 1; j <= 3; j++) {
        dp[i] = Math.max(dp[i], sum - dp[i + j]);
      }
    }

    if (sum - dp[0] == dp[0]) {
      return "Tie";
    }

    if (sum - dp[0] > dp[0]) {
      return "Bob";
    }

    return "Alice";
  }
}
