class Solution {
  public int searchIndex(int[] nums, int left, int right, int target, String mode) {
    while (left <= right) {
      int middle = (left + right) / 2;

      boolean isBoundary = mode.equals("start")
        ? middle == 0 || nums[middle - 1] != target
        : middle == nums.length - 1 || nums[middle + 1] != target;

      if (target == nums[middle] && isBoundary) {
        return middle;
      }

      boolean shouldSearchTowardsLeft = mode.equals("start")
        ? target <= nums[middle]
        : target < nums[middle];

      if (shouldSearchTowardsLeft) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return -1;
  }

  public int[] searchRange(int[] nums, int target) {
    int startIndex = searchIndex(nums, 0, nums.length - 1, target, "start");
    int endIndex = startIndex > -1
      ? searchIndex(nums, startIndex, nums.length - 1, target, "end")
      : -1;
    return new int[] {startIndex, endIndex};
  }
}
