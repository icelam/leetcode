class Solution {
  public int longestSubarray(int[] nums) {
    int n = nums.length;
    int maxValue = Integer.MIN_VALUE;
    int longestConsecutiveCountOfMaxValue = 1;

    for (int start = 0, consecutiveCount = 1; start < n; start += consecutiveCount, consecutiveCount = 1) {
      while (start + consecutiveCount < n && nums[start + consecutiveCount] == nums[start]) {
        consecutiveCount++;
      }

      if (nums[start] == maxValue) {
        longestConsecutiveCountOfMaxValue = Math.max(longestConsecutiveCountOfMaxValue, consecutiveCount);
      } else if (nums[start] > maxValue) {
        maxValue = nums[start];
        longestConsecutiveCountOfMaxValue = consecutiveCount;
      }
    }

    return longestConsecutiveCountOfMaxValue;
  }
}
