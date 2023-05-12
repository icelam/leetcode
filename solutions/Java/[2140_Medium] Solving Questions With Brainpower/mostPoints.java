class Solution {
  public long mostPoints(int[][] questions) {
    int n = questions.length;
    long[] dp = new long[n + 1];

    for (int i = 0; i < n; i++) {
      dp[i + 1] = Math.max(dp[i + 1], dp[i]);
      int next = Math.min(i + questions[i][1] + 1, n);
      dp[next] = Math.max(dp[next], dp[i] + questions[i][0]);
    }

    return dp[n];
  }
}
