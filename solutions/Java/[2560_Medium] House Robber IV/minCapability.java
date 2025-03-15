class Solution {
  private boolean isValid(int[] nums, int k, int max) {
    int count = 0;
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      if (nums[i] <= max) {
        count++;
        i++;
      }
    }

    return count >= k;
  }

  public int minCapability(int[] nums, int k) {
    int left = 0;
    int right = 0;

    for (int value : nums) {
      right = Math.max(right, value);
    }

    while (left + 1 < right) {
      int middle = left + (right - left) / 2;

      if (isValid(nums, k, middle)) {
        right = middle;
      } else {
        left = middle;
      }
    }

    return right;
  }
}
