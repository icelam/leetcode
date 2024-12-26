class Solution {
  private int count = 0;

  public void backtrack(int[] nums, int target, int index, int sum) {
    if (index == nums.length) {
      if (sum == target) {
        count++;
      }

      return;
    }

    backtrack(nums, target, index + 1, sum + nums[index]);
    backtrack(nums, target, index + 1, sum - nums[index]);
  }

  public int findTargetSumWays(int[] nums, int target) {
    backtrack(nums, target, 0, 0);
    return count;
  }
}
