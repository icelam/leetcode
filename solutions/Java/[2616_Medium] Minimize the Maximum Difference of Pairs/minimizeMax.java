class Solution {
  public int minimizeMax(int[] nums, int p) {
    Arrays.sort(nums);

    int n = nums.length;
    int left = 0;
    int right = nums[n - 1] - nums[0];

    while (left < right) {
      int middle = left + (right - left) / 2;
      int validPairCount = 0;

      for (int i = 0; i < n - 1; i++) {
        if (nums[i + 1] - nums[i] <= middle) {
          validPairCount++;
          i++;
        }
      }

      if (validPairCount >= p) {
        right = middle;
      } else {
        left = middle + 1;
      }
    }

    return left;
  }
}
