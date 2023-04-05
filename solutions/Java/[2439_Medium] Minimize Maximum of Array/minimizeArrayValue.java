class Solution {
  public int minimizeArrayValue(int[] nums) {
    int n = nums.length;
    int result = nums[0];
    long sum = nums[0];

    // Check whether the maximum value of block can be obtained or optimized.
    //
    // Case 1: Adding a new number that is smaller than current maximum
    // This number cannot make the previous value smaller or increase itself
    // and will not affect result.
    //
    // Case 2: Adding a new number that is greater than current maximum
    // The new number will be able to share part of its value to the previous number
    // and get the optimal solution.
    for (int i = 1; i < n; i++) {
      sum += nums[i];
      result = Math.max(result, (int) Math.ceil(sum * 1.0 / (i + 1)));
    }

    return result;
  }
}
