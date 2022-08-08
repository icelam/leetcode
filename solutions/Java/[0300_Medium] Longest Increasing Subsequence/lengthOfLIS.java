class Solution {
  public int lengthOfLIS(int[] nums) {
    int result = 0;
    int[] dp = new int[nums.length];

    for (int n: nums) {
      int left = Arrays.binarySearch(dp, 0, result, n);

      // Not found, Arrays.binarySearch return the insertion point
      if (left < 0) {
        left = -left - 1;
      }

      if (left == result) {
        result++;
      }

      dp[left] = n;
    }

    return result;
  }
}
