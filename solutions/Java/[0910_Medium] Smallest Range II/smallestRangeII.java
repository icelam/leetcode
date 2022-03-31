class Solution {
  public int smallestRangeII(int[] nums, int k) {
    if (nums.length == 1) {
      return 0;
    }

    Arrays.sort(nums);

    int length = nums.length;
    int result = nums[length - 1] - nums[0];

    for (int i = 1; i < nums.length; i++) {
      int high = Math.max(nums[length - 1] - k, nums[i - 1] + k);
      int low = Math.min(nums[0] + k, nums[i] - k);
      result = Math.min(result, high - low);
    }

    return result;
  }
}
