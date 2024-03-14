class Solution {
  public int numSubarraysWithSum(int[] nums, int goal) {
    int n = nums.length;
    int left = 0;
    int right = 0;
    int leadingZeroCount = 0;
    int sum = 0;
    int result = 0;

    while (right < n) {
      sum += nums[right];

      while (left < right && (sum > goal || nums[left] == 0)) {
        if (nums[left] == 1) {
          leadingZeroCount = 0;
        } else {
          leadingZeroCount++;
        }

        sum -= nums[left];
        left++;
      }

      if (sum == goal) {
        result += 1 + leadingZeroCount;
      }

      right++;
    }

    return result;
  }
}
