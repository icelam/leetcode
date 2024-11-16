class Solution {
  public int[] resultsArray(int[] nums, int k) {
    int n = nums.length;
    int count = 0;
    int[] result = new int[n - k + 1];

    Arrays.fill(result, -1);

    for (int i = 0; i < n; i++) {
      count = (i == 0 || nums[i] == nums[i - 1] + 1 ? count + 1 : 1);
      if (count >= k) {
        result[i - k + 1] = nums[i];
      }
    }

    return result;
  }
}
