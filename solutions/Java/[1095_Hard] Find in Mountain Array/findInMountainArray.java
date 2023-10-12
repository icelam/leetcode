/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
  private int findPeakIndex(MountainArray arr) {
    int n = arr.length();
    int left = 0;
    int right = n - 1;

    while (left <= right) {
      int middle = left + (right - left) / 2;
      int currentValue = arr.get(middle);
      // Cache left and right value since "Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer"
      int leftValue = middle > 1
        ? arr.get(middle - 1)
        : -1;
      int rightValue = middle < n - 1
        ? arr.get(middle + 1)
        : -1;

      if (currentValue > leftValue && currentValue > rightValue) {
        return middle;
      } else if (currentValue < leftValue) {
        right = middle - 1;
      } else if (currentValue > leftValue) {
        left = middle + 1;
      }
    }

    return -1;
  }

  private int binarySearch(MountainArray arr, int target, int left, int right, boolean searchLeft) {
    while (left <= right) {
      int middle = left + (right - left) / 2;
      int value = arr.get(middle);

      if (value == target) {
        return middle;
      } else if ((searchLeft && value > target) || (!searchLeft && value < target)) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return -1;
  }

  public int findInMountainArray(int target, MountainArray mountainArr) {
    int peak = findPeakIndex(mountainArr);

    int left = binarySearch(mountainArr, target, 0, peak, true);

    if (left != -1) {
      return left;
    }

    return binarySearch(mountainArr, target, peak, mountainArr.length() - 1, false);
  }
}
