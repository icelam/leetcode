class Solution {
  public int maxAscendingSum(int[] nums) {
    int previous = Integer.MIN_VALUE;
    int currentSum = 0;
    int maxSum = 0;

    for (int value: nums) {
      if (value > previous) {
        currentSum += value;
        maxSum = Math.max(maxSum, currentSum);
      } else {
        currentSum = value;
      }

      previous = value;
    }

    return maxSum;
  }
}
