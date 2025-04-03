class Solution {
  public long maximumTripletValue(int[] nums) {
    int n = nums.length;
    long result = 0;
    long maxPrefix = 0;
    long maxDiff = 0;

    for (int k = 0; k < n; k++) {
      result = Math.max(result, maxDiff * nums[k]);
      maxDiff = Math.max(maxDiff, maxPrefix - nums[k]);
      maxPrefix = Math.max(maxPrefix, nums[k]);
    }

    return result;
  }
}
