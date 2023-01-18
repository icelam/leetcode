class Solution {
  public int maxSubarraySumCircular(int[] nums) {
    int length = nums.length;
    int maxContinuousSum = Integer.MIN_VALUE;
    int currentSum = 0;

    // Case 1: Max sum without split (circular), use Kadane's algorithm
    for (int i = 0; i < length; i++) {
      if (nums[i] + currentSum > nums[i]) {
        currentSum += nums[i];
      } else {
        currentSum = nums[i];
      }

      if (currentSum > maxContinuousSum) {
        maxContinuousSum = currentSum;
      }
    }

    // Case 2: Max sum with split, find max prefix and max suffix
    int[] prefixSum = new int[length];
    prefixSum[0] = nums[0];

    for (int i = 1; i < length; i++) {
      prefixSum[i] += prefixSum[i - 1] + nums[i];
    }

    int maxNonContinuousSum = Integer.MIN_VALUE;
    int maxPrefixSum = nums[0];
    int maxSuffixSum = 0;

    for (int i = 0; i < length; i++) {
      maxPrefixSum = Math.max(prefixSum[i], maxPrefixSum);
      maxSuffixSum = prefixSum[length - 1] - prefixSum[i];
      maxNonContinuousSum = Math.max(maxNonContinuousSum, maxPrefixSum + maxSuffixSum);
    }

    return Math.max(maxContinuousSum, maxNonContinuousSum);
  }
}
