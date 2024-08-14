class Solution {
  public int smallestDistancePair(int[] nums, int k) {
    int n = nums.length;

    Arrays.sort(nums);

    int left = 0;
    int right = nums[n - 1] - nums[0];

    while (left <= right) {
      int middle = (left + right) / 2;
      int count = 0;

      for (int i = 0, j = 0; j < n; j++) {
        while (nums[j] - nums[i] > middle) {
          i++;
        }
        count += j - i;
      }

      if (count >= k) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return left;
  }
}
