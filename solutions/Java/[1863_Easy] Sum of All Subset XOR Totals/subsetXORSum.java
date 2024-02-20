class Solution {
  private int result = 0;

  private void dfs(int[] nums, int index, int xorResult) {
    result += xorResult;

    for (int i = index; i < nums.length; i++) {
      dfs(nums, i + 1, xorResult ^ nums[i]);
    }
  }

  public int subsetXORSum(int[] nums) {
    dfs(nums, 0, 0);
    return result;
  }
}
