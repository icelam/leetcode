class Solution {
  public int maxSubarrayLength(int[] nums, int k) {
    int n = nums.length;
    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;

    for (int value : nums) {
      minValue = Math.min(minValue, value);
      maxValue = Math.max(maxValue, value);
    }

    int[] frequency = new int[maxValue - minValue + 1];
    int left = 0;
    int right = 0;
    int result = 1;

    while (right < n) {
      frequency[nums[right] - minValue]++;

      while (frequency[nums[right] - minValue] > k) {
        frequency[nums[left] - minValue]--;
        left++;
      }

      result = Math.max(result, right - left + 1);
      right++;
    }

    return result;
  }
}
