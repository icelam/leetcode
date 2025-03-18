class Solution {
  public int longestNiceSubarray(int[] nums) {
    int result = 0;

    for (int i = 0; i < nums.length; i++) {
      int or = 0;
      int j = i;

      for (; j >= 0 && (or & nums[j]) == 0; j--) {
        or |= nums[j];
      }

      result = Math.max(result, i - j);
    }

    return result;
  }
}
