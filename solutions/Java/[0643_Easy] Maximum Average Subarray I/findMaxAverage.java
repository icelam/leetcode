class Solution {
  public double findMaxAverage(int[] nums, int k) {
    int n = nums.length;
    int[] prefixSum = new int[n + 1];
    double result = Integer.MIN_VALUE;

    for (int i = 1; i <= n; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
    }

    for (int i = k; i <= n; i++) {
      result = Math.max(((double) prefixSum[i] - prefixSum[i - k]) / k, result);
    }

    return result;
  }
}
