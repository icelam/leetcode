class Solution {
  public int singleNonDuplicate(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int middle = (right - left) / 2 + left;
      middle -= middle & 1;

      if (nums[middle + 1] == nums[middle]) {
        left = middle + 2;
      } else {
        right = middle;
      }
    }

    return nums[left];
  }
}
