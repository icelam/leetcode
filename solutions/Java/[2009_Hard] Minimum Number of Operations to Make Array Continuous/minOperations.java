class Solution {
  public int minOperations(int[] nums) {
    int n = nums.length;

    if (n <= 1) {
      return 0;
    }

    Arrays.sort(nums);

    // Deduplicate
    int length = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[length] != nums[i]) {
        length++;
        nums[length] = nums[i];
      }
    }

    int result = 0;

    for (int i = 1; i <= length; i++) {
      int left = 0;
      int right = i;

      while (left < right) {
        int middle = left + (right - left) / 2;

        if (nums[middle] < nums[i] - n + 1) {
          left = middle + 1;
        } else {
          right = middle;
        }
      }

      result = Math.max(result, i - right + 1);
    }

    return n - result;
  }
}
