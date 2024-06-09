class Solution {
  public int largestSumAfterKNegations(int[] nums, int k) {
    int min = Integer.MAX_VALUE;
    int sum = 0;

    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0 && k > 0) {
        nums[i] = -1 * nums[i];
        k--;
      }

      sum += nums[i];
      min = Math.min(min, nums[i]);
    }

    if (k % 2 == 0) {
      return sum;
    }

    return sum - (2 * min);
  }
}
