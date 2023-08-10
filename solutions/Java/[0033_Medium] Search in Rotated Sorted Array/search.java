class Solution {
  private int findPivot(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    int rightMostNum = arr[right];

    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (arr[middle] > rightMostNum) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }

    return left;
  }

  private int binarySearch(int[] arr, int target, int left, int right) {
    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (arr[middle] == target) {
        return middle;
      }

      if (arr[middle] < target) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }

    return -1;
  }

  public int search(int[] nums, int target) {
    int n = nums.length;
    int pivotIndex = findPivot(nums);
    int left = target > nums[n - 1] ? 0 : pivotIndex;
    int right = target > nums[n - 1] ? pivotIndex - 1 : n - 1;
    return binarySearch(nums, target, left, right);
  }
}
