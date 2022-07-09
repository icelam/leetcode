class Solution {
  public int maxResult(int[] nums, int k) {
    int n = nums.length;
    int MIN_SCORE = -1000000001;

    int[] dp = new int[n];
    Arrays.fill(dp, MIN_SCORE);
    dp[nums.length - 1] = nums[nums.length - 1];

    for (int i = n - 1; i >= 0; i--) {
      for (int moves = 1; moves <= k && i - moves >= 0; moves++) {
        int newIndex = i - moves;
        int score = dp[i] + nums[newIndex];

        if (score > dp[newIndex]) {
          dp[newIndex] = score;
        }

        if (dp[newIndex] >= dp[i]) {
          break;
        }
      }
    }

    return dp[0];
  }
}
