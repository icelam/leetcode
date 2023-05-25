class Solution {
  public double new21Game(int n, int k, int maxPts) {
    if (n - k + 1 >= maxPts) {
      return 1.0;
    }

    double[] dp = new double[k + maxPts];

    for (int i = k; i <= n; i++) {
      dp[i] = 1.0;
    }

    double sum = n - k + 1;

    for (int i = k - 1; i >= 0; i--) {
      dp[i] = sum / maxPts;
      sum = sum - dp[i + maxPts] + dp[i];
    }

    return dp[0];
  }
}
