class Solution {
  private int findPivot (int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right && arr[0] == arr[right]) {
      right--;
    }

    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (arr[middle] >= arr[0]) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }

    // Not rotated
    if (left == arr.length) {
      return 0;
    }

    return left;
  }

  private boolean binarySearch(int[] arr, int target, int left, int right) {
    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (arr[middle] == target) {
        return true;
      }

      if (arr[middle] < target) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }

    return false;
  }

  public boolean search(int[] nums, int target) {
    int n = nums.length;
    int pivotIndex = findPivot(nums);
    int left = target > nums[n - 1] ? 0 : pivotIndex;
    int right = target > nums[n - 1] ? pivotIndex - 1 : n - 1;

    return binarySearch(nums, target, left, right);
  }
}
