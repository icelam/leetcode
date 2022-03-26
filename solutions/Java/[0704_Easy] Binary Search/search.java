class Solution {
  public int search(int[] nums, int target) {
    int length = nums.length;

    int left = 0;
    int right = length - 1;
    int middle = nums.length / 2;

    while (left <= right) {
      middle = (left + right) / 2;

      if (target == nums[middle]) {
        return middle;
      }

      if (target < nums[middle]) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return -1;
  }
}
