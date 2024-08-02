class Solution {
  public int minSwaps(int[] nums) {
    int n = nums.length;
    int windowSize = 0;
    int result = 0;

    for (int value: nums) {
      windowSize += value;
    }

    if (windowSize == 0) {
      return 0;
    }

    int prefixSum = 0;
    int minMoves = Integer.MAX_VALUE;

    for (int i = 0; i < n + windowSize - 1; i++) {
      prefixSum += nums[i % n];

      if (i >= windowSize) {
        prefixSum -= nums[i - windowSize];
      }

      minMoves = Math.min(minMoves, windowSize - prefixSum);
    }

    return minMoves;
  }
}
