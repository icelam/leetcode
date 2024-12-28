class Solution {
  private static int MAX_SUBARRAY = 3;

  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int n = nums.length;
    int[] prefixSum = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
    }

    int[][] maxSum = new int[4][n + 1];
    int[][] maxIndex = new int[4][n + 1];

    for (int i = 1; i <= MAX_SUBARRAY; i++) {
      for (int end = k * i; end <= n; end++) {
        int currentSum = prefixSum[end] - prefixSum[end - k] + maxSum[i - 1][end - k];

        if (currentSum > maxSum[i][end - 1]) {
          maxSum[i][end] = currentSum;
          maxIndex[i][end] = end - k;
        } else {
          maxSum[i][end] = maxSum[i][end - 1];
          maxIndex[i][end] = maxIndex[i][end - 1];
        }
      }
    }

    int[] result = new int[MAX_SUBARRAY];
    int currentEnd = n;

    for (int i = MAX_SUBARRAY; i >= 1; i--) {
      result[i - 1] = maxIndex[i][currentEnd];
      currentEnd = result[i - 1];
    }

    return result;
  }
}
