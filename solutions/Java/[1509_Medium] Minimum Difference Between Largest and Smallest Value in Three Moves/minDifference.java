class Solution {
  public int minDifference(int[] nums) {
    int n = nums.length;
    int maxMove = 3;
    int left = 0;
    int right = n - maxMove - 1;
    int result = Integer.MAX_VALUE;

    if (right <= left) {
      return 0;
    }

    Arrays.sort(nums);

    while (right < n) {
      result = Math.min(result, nums[right] - nums[left]);
      left++;
      right++;
    }

    return result;
  }
}
