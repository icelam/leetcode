class Solution {
  public int findBoundary(int[] arr, int target, int left, int right, boolean searchLeft) {
    int index = -1;

    while (left <= right){
      int middle = left + (right - left) / 2;

      if (arr[middle] == target) {
        index = middle;

        if (searchLeft) {
          right = middle - 1;
        } else {
          left = middle + 1;
        }
      } else if (arr[middle] > target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return index;
  }

  public int[] searchRange(int[] nums, int target) {
    int n = nums.length;
    int left = findBoundary(nums, target, 0, n - 1, true);

    if (left == -1) {
      return new int[]{-1, -1};
    }

    int right = findBoundary(nums, target, left, n - 1, false);

    return new int[]{left, right};
  }
}
