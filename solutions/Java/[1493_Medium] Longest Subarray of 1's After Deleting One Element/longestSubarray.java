class Solution {
  public int longestSubarray(int[] nums) {
    int n = nums.length;
    int numberOfZeros = 0;
    int maxLength = 0;
    int start = 0;

    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        numberOfZeros++;
      }

      while (numberOfZeros > 1) {
        if (nums[start] == 0) {
          numberOfZeros--;
        }

        start++;
      }

      maxLength = Math.max(maxLength, i - start);
    }

    return maxLength;
  }
}
