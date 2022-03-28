class Solution {
  public int findPivot(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < arr[i - 1]) {
        return i;
      }
    }
    return 0;
  }

  public boolean binarySearch(int[] nums, int left, int right, int target) {
    while (left <= right) {
      int middle = (left + right) / 2;

      if (target == nums[middle]) {
        return true;
      }

      if (target < nums[middle]) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return false;
  }

  public boolean search(int[] nums, int target) {
    int pivot = findPivot(nums);

    boolean result1 = binarySearch(nums, 0, pivot - 1, target);
    boolean result2 = binarySearch(nums, pivot, nums.length - 1, target);

    return result1 || result2;
  }
}
