class Solution {
  public long largestPerimeter(int[] nums) {
    int k = nums.length;
    long prefixSum = 0;
    Arrays.sort(nums);

    for (int i = 0; i < k; i++) {
      prefixSum += nums[i];
    }

    for (int i = k - 1; i >= 2; i--) {
      if (prefixSum - nums[i] > nums[i]) {
        return prefixSum;
      }

      prefixSum -= nums[i];
    }

    return -1;
  }
}
