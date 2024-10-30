class Solution {
  public int minimumMountainRemovals(int[] nums) {
    int n = nums.length;
    int[] longestIncreasingSequence = new int[n];
    int[] longestDecreasingSequence = new int[n];

    Arrays.fill(longestIncreasingSequence, 1);
    Arrays.fill(longestDecreasingSequence, 1);

    for (int i = 0; i < n; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] > nums[j]) {
          longestIncreasingSequence[i] = Math.max(longestIncreasingSequence[i], longestIncreasingSequence[j] + 1);
        }
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        if (nums[i] > nums[j]) {
          longestDecreasingSequence[i] = Math.max(longestDecreasingSequence[i], longestDecreasingSequence[j] + 1);
        }
      }
    }

    int result = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      if (longestIncreasingSequence[i] > 1 && longestDecreasingSequence[i] > 1) {
        result = Math.min(result, n - longestIncreasingSequence[i] - longestDecreasingSequence[i] + 1);
      }
    }

    return result;
  }
}
