class Solution {
  public int longestArithSeqLength(int[] nums) {
    int n = nums.length;
    int result = 0;
    int[][] dp = new int[n][1001];

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        // Since difference can be number between -500 to 500, adding 500 to make it become 0 - 1000,
        // so that it becomes valid to use in array index
        int difference = nums[i] - nums[j] + 500;
        dp[i][difference] = Math.max(dp[i][difference], dp[j][difference] + 1);
        result = Math.max(result, dp[i][difference]);
      }
    }

    return result + 1;
  }
}
