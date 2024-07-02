class Solution {
  public int minOperations(int[] nums) {
    int n = nums.length;
    int minOperations = 0;

    for (int i = 1; i < n; i++) {
      if (nums[i - 1] >= nums[i]) {
        int diff = (nums[i - 1] - nums[i]) + 1;
        nums[i] += diff;
        minOperations += diff;
      }
    }

    return minOperations;
  }
}
