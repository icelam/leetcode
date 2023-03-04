class Solution {
  public long countSubarrays(int[] nums, int minK, int maxK) {
    int n = nums.length;
    long result = 0;
    int left = 0;
    int minIndex = -1;
    int maxIndex = -1;

    for (int i = 0; i < n; i++) {
      if (nums[i] == minK) {
        minIndex = i;
      }

      if (nums[i] == maxK) {
        maxIndex = i;
      }

      if (nums[i] < minK || nums[i] > maxK) {
        left = i + 1;
        minIndex = -1;
        maxIndex = -1;
        continue;
      }

      if (minIndex != -1 && maxIndex != -1) {
        result += Math.min(minIndex, maxIndex) - left + 1;
      }
    }

    return result;
  }
}
