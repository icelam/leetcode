class Solution {
  public int maxAbsoluteSum(int[] nums) {
    int n = nums.length;
    int minPrefixSum = 0;
    int maxPrefixSum = 0;
    int prefixSum = 0;

    for (int i = 0; i < n; i++) {
      prefixSum += nums[i];
      minPrefixSum = Math.min(minPrefixSum, prefixSum);
      maxPrefixSum = Math.max(maxPrefixSum, prefixSum);
    }

    return maxPrefixSum - minPrefixSum;
  }
}
