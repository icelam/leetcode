class Solution {
  public boolean PredictTheWinner(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n][n];

    // Base case
    for (int i = 0; i < n; i++) {
      dp[i][i] = nums[i];
    }

    for (int i = n - 2; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        int pickI = nums[i] - dp[i + 1][j];
        int pickJ = nums[j] - dp[i][j - 1];
        dp[i][j] = Math.max(pickI, pickJ);
      }
    }

    return dp[0][n - 1] >= 0;
  }
}
