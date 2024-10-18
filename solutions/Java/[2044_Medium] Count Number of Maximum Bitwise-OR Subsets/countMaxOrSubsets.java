class Solution {
  public int countMaxOrSubsets(int[] nums) {
    int n = nums.length;
    int mask = 1 << n;
    int max = 0;
    int result = 0;

    for (int subsetMask = 0; subsetMask < mask; subsetMask++) {
      int current = 0;

      for (int i = 0; i < n; i++) {
        if (((subsetMask >> i) & 1) == 1) {
          current |= nums[i];
        }
      }

      if (current > max) {
        max = current;
        result = 1;
      } else if (current == max) {
        result++;
      }
    }

    return result;
  }
}
