class Solution {
  public int pivotIndex(int[] nums) {
    int length = nums.length;
    int[] prefixSum = new int[length];
    prefixSum[0] = nums[0];

    for (int i = 1; i < length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i];
    }

    for (int i = 0; i < length; i++) {
      int leftSum = prefixSum[i] - nums[i];
      int rightSum = prefixSum[length - 1] - prefixSum[i];

      if (leftSum == rightSum) {
        return i;
      }
    }

    return -1;
  }
}
