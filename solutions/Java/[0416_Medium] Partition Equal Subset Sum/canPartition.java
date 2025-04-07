class Solution {
  public boolean canPartition(int[] nums) {
    int n = nums.length;

    if (n < 2) {
      return false;
    }

    int sum = 0;
    int maxNum = 0;

    for (int value : nums) {
      sum += value;
      maxNum = Math.max(maxNum, value);
    }

    if (sum % 2 != 0 || maxNum > sum / 2) {
      return false;
    }

    int halfOfSum = sum / 2;
    boolean[][] dp = new boolean[n][halfOfSum + 1];

    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }

    dp[0][nums[0]] = true;

    for (int i = 1; i < n; i++) {
      int num = nums[i];

      for (int j = 1; j <= halfOfSum; j++) {
        if (j >= num) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n - 1][halfOfSum];
  }
}
