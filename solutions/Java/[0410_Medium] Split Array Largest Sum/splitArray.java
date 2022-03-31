class Solution {
  public int splitRequired(int[] nums, int limit) {
    int sum = 0;
    int count = 0;

    for (int n: nums) {
      if (sum + n <= limit) {
        sum += n;
      } else {
        sum = n;
        count++;
      }
    }

    return count + 1;
  }

  public int splitArray(int[] nums, int m) {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int n: nums) {
      sum += n;
      max = Math.max(max, n);
    }

    int left = max;
    int right = sum;
    int result = 0;

    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (splitRequired(nums, middle) <= m) {
        right = middle - 1;
        result = middle;
      } else {
        left = middle + 1;
      }
    }

    return result;
  }
}
