class Solution {
  public long maximumSubarraySum(int[] nums, int k) {
    int n = nums.length;
    long currentSum = 0;
    long maxSum = 0;
    int[] frequency = new int[100001];
    int uniqueCount = 0;

    for (int i = 0; i < n; i++) {
      currentSum += nums[i];
      if (frequency[nums[i]] == 0) {
        uniqueCount++;
      }
      frequency[nums[i]]++;

      if (i >= k) {
        currentSum -= nums[i - k];
        frequency[nums[i - k]]--;
        if (frequency[nums[i - k]] == 0) {
          uniqueCount--;
        }
      }

      if (i >= k - 1 && uniqueCount == k) {
        maxSum = Math.max(maxSum, currentSum);
      }
    }

    return maxSum;
  }
}
