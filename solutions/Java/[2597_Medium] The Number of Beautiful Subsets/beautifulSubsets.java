class Solution {
  private int dfs(int[] nums, int k, int i, int[] frequency) {
    int beautifulSetCount = 1;

    if (i == nums.length) {
      return beautifulSetCount;
    }

    for (int j = i; j < nums.length; ++j) {
      int x = nums[j] + k;

      if (frequency[x - k] == 0 && frequency[x + k] == 0) {
        frequency[x]++;
        beautifulSetCount += dfs(nums, k, j + 1, frequency);
        frequency[x]--;
      }
    }

    return beautifulSetCount;
  }

  public int beautifulSubsets(int[] nums, int k) {
    return dfs(nums, k, 0, new int[1001 + (2 * k)]) - 1;
  }
}
