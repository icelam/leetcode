class Solution {
  private int[] memo;

  public int maximizeProfit(int[] nums, int id) {
    if (id >= nums.length) {
      return 0;
    }

    if (memo[id] >= 0) {
      return memo[id];
    }

    memo[id] = Math.max(
      nums[id] + maximizeProfit(nums, id + 2),
      0 + maximizeProfit(nums, id + 1)
    );

    return memo[id];
  }

  public int rob(int[] nums) {
    memo = new int[nums.length];
    Arrays.fill(memo, -1);
    return maximizeProfit(nums, 0);
  }
}
