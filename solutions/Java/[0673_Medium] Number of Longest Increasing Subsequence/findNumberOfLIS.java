class Solution {
  public int findNumberOfLIS(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }

    int maxCount = 0;
    int[] dp = new int[nums.length];
    int[] count = new int[nums.length];

    Arrays.fill(dp, 1);
    Arrays.fill(count, 1);

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          if (dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1;
            count[i] = count[j];
          } else if (dp[j] + 1 == dp[i]) {
            count[i] += count[j];
          }
        }

        if (dp[i] > maxCount) {
          maxCount = dp[i];
        }
      }
    }

    int result = 0;

    for (int i = 0; i < nums.length; i++) {
      if (maxCount == dp[i]) {
        result += count[i];
      }
    }

    return result;
  }
}
