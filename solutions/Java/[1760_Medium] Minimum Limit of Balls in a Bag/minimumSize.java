class Solution {
  public int minimumSize(int[] nums, int maxOperations) {
    int left = 1;
    int right = Integer.MIN_VALUE;

    for (int value: nums) {
      right = Math.max(right, value);
    }

    int results = 0;

    while (left <= right) {
      long operations = 0;
      int middle = left + (right - left) / 2;

      for (int value : nums) {
        operations += (value - 1) / middle;
      }

      if (operations <= maxOperations) {
        results = middle;
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return results;
  }
}
