class Solution {
  public int[] getAverages(int[] nums, int k) {
    if (k == 0) {
      return nums;
    }

    int windowSize = k * 2 + 1;
    int n = nums.length;
    long prefixSum = 0;

    int[] result = new int[n];
    Arrays.fill(result, -1);

    for (int i = 0; i < n; i++) {
      prefixSum += nums[i];

      if (i >= windowSize) {
        prefixSum -= nums[i - windowSize];
      }

      if (i >= windowSize - 1) {
        result[i - k] = (int) (prefixSum / windowSize);
      }
    }

    return result;
  }
}
