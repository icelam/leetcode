class Solution {
  public int findNonMinOrMax(int[] nums) {
    if (nums.length <= 2) {
      return -1;
    }

    // Sort first 3 number, since first 3 number always contains a valid result
    Arrays.sort(nums, 0, 3);
    return nums[1];
  }
}
