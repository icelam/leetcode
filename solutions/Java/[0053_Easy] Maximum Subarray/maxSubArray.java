class Solution {
  public int maxSubArray(int[] nums) {
    int result = nums[0];
    int currentSum = 0;

    for (int n: nums) {
      currentSum += n;

      if (currentSum > result) {
        result = currentSum;
      }

      if (currentSum < 0) {
        currentSum = 0;
      }
    }

    return result;
  }
}
