class Solution {
  private int binarySearch(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      int middle = left + (right - left) / 2;

      if (arr[middle] < arr[middle + 1]) {
        left = middle + 1;
      } else {
        right = middle;
      }
    }

    return left;
  }

  public int peakIndexInMountainArray(int[] arr) {
    return binarySearch(arr);
  }
}
