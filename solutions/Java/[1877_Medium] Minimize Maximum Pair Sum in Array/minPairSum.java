class Solution {
  public int minPairSum(int[] nums) {
    int n = nums.length;
    int m = n / 2;
    int result = Integer.MIN_VALUE;

    Arrays.sort(nums);

    for (int i = 0, j = n - 1; i < m; i++, j--) {
      result = Math.max(result, nums[i] + nums[j]);
    }

    return result;
  }
}
