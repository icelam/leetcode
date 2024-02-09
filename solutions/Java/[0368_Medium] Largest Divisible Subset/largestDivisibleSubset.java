class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];

    Arrays.sort(nums);
    Arrays.fill(dp, 1);

    int maxSubsetSize = 1;
    int maxValue = nums[0];

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }

      if (dp[i] > maxSubsetSize) {
        maxSubsetSize = dp[i];
        maxValue = nums[i];
      }
    }

    List<Integer> result = new ArrayList<>();

    for (int i = n - 1; i >= 0 && maxSubsetSize > 0; i--) {
      if (dp[i] == maxSubsetSize && maxValue % nums[i] == 0) {
        result.add(nums[i]);
        maxValue = nums[i];
        maxSubsetSize--;
      }
    }

    return result;
  }
}
