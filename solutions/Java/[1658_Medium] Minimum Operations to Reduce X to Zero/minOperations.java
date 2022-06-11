class Solution {
  public int minOperations(int[] nums, int x) {
    int sum = 0;

    for (int n: nums) {
      sum += n;
    }

    int maxLength = -1;
    int currentSum = 0;

    for (int left = 0, right = 0; right < nums.length; right++) {
      currentSum += nums[right];

      while (left <= right && currentSum > sum - x) {
        currentSum -= nums[left];
        left++;
      }

      if (currentSum == sum - x) {
        maxLength = Math.max(maxLength, right - left + 1);
      }
    }

    return maxLength == -1 ? -1 : nums.length - maxLength;
  }
}
