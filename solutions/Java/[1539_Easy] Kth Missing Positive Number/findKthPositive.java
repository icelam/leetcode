class Solution {
  public int findKthPositive(int[] arr, int k) {
    if (arr[0] > k) {
      return k;
    }

    int left = 0;
    int right = arr.length;

    while (left < right) {
      int middle = left + (right - left) / 2;
      int target = middle < arr.length
        ? arr[middle]
        : Integer.MAX_VALUE;
      if (target - middle - 1 >= k) {
        right = middle;
      } else {
        left = middle + 1;
      }
    }

    return k - (arr[left - 1] - (left - 1) - 1) + arr[left - 1];
  }
}
