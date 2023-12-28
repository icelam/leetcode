class Solution {
  public int[] numberGame(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    Arrays.sort(nums);

    for (int i = 0, j = 1; j < n; i += 2, j += 2) {
      result[i] = nums[j];
      result[j] = nums[i];
    }

    return result;
  }
}
