class Solution {
  public int minimumAverageDifference(int[] nums) {
    int n = nums.length;

    if (n == 0) {
      return 0;
    }

    int minIndex = -1;
    long minDifference = Integer.MAX_VALUE;
    long[] prefixSum = new long[n + 1];

    for (int i = 0; i < n; i++) {
      prefixSum[i + 1] = prefixSum[i] + nums[i];
    }

    for (int j = 1; j <= n; j++) {
      long value1 = prefixSum[j];
      int length1 = j;
      long value2 = prefixSum[n] - prefixSum[j];
      int length2 = n - j;

      long difference = length2 > 0
        ? value1 / length1 - value2 / length2
        : value1 / length1;

      long absoluteDifference = (long) Math.abs(difference);

      if (absoluteDifference < minDifference) {
        minIndex = j - 1;
        minDifference = absoluteDifference;
      }
    }

    return minIndex;
  }
}
