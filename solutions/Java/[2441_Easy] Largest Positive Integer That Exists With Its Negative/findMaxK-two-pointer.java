class Solution {
  public int findMaxK(int[] nums) {
    Arrays.sort(nums);

    int n = nums.length;
    int left = 0;
    int right = n - 1;

    while (nums[left] < 0 && nums[right] > 0 && left < right) {
      if (nums[left] * -1 == nums[right]) {
        return nums[right];
      }

      if (nums[left] * -1 > nums[right]) {
        left++;
      } else {
        right--;
      }
    }

    return -1;
  }
}
