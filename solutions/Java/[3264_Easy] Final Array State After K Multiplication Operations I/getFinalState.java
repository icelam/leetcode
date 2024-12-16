class Solution {
  public int[] getFinalState(int[] nums, int k, int multiplier) {
    int n = nums.length;

    while (k > 0) {
      int minIndex = 0;

      for (int i = 0; i < n; i++) {
        if (nums[i] < nums[minIndex]) {
          minIndex = i;
        }
      }

      nums[minIndex] *= multiplier;
      k--;
    }

    return nums;
  }
}
