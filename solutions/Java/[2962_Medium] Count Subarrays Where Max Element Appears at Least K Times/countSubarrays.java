class Solution {
  public long countSubarrays(int[] nums, int k) {
    int n = nums.length;
    int maxValue = Integer.MIN_VALUE;

    for (int value : nums) {
      maxValue = Math.max(maxValue, value);
    }

    int left = 0;
    int right = 0;
    long result = 0;
    int maxValueCount = 0;

    while (right < n) {
      if (nums[right] == maxValue) {
        maxValueCount++;
      }

      while (k == maxValueCount) {
        if (nums[left] == maxValue) {
          maxValueCount--;
        }

        left++;
      }

      result += left;
      right++;
    }

    return result;
  }
}
