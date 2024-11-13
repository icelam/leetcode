class Solution {
  public long countPairs(int[] nums, int target) {
    int n = nums.length;
    long count = 0;
    int left = 0;
    int right = n - 1;

    while (left < right) {
      if (nums[left] + nums[right] < target) {
        count += (right - left);
        left++;
      } else {
        right--;
      }
    }

    return count;
  }

  public long countFairPairs(int[] nums, int lower, int upper) {
    Arrays.sort(nums);
    return countPairs(nums, upper + 1) - countPairs(nums, lower);
  }
}
