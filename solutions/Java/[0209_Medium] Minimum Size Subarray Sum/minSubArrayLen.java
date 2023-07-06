class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int left = 0;
    int sum = 0;
    int count = Integer.MAX_VALUE;

    for (int right = 0; right < n; right++) {
      sum += nums[right];

      while (sum >= target) {
        count = Math.min(count, right - left + 1);
        sum -= nums[left];
        left++;
      }
    }

    return count == Integer.MAX_VALUE ? 0 : count;
  }
}
