class Solution {
  public int maximumCount(int[] nums) {
    int n = nums.length;
    int positiveCount = n;
    int zeroCount = 0;

    for (int value: nums) {
      if (value > 0) {
        break;
      }

      if (value == 0) {
        zeroCount++;
      }

      positiveCount--;
    }

    int negativeCount = n - positiveCount - zeroCount;
    return Math.max(positiveCount, negativeCount);
  }
}
