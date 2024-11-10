class Solution {
  private static int MAX_BIT = 32;

  public int minimumSubarrayLength(int[] nums, int k) {
    int n = nums.length;
    int[] bit = new int[MAX_BIT];
    int result = Integer.MAX_VALUE;

    int start = 0;
    int end = 0;
    int or = 0;

    while (end < n) {
      int num = nums[end];
      or |= num;
      int mask = 1;

      for (int i = 0; i < MAX_BIT; i++) {
        if ((num & mask) != 0) {
          bit[i]++;
        }

        mask <<= 1;
      }

      end++;

      while (start < end && or >= k) {
        result = Math.min(result, end - start);
        num = nums[start];
        mask = 1;

        for (int i = 0; i < MAX_BIT; i++) {
          if ((num & mask) != 0 && bit[i] > 0) {
            bit[i]--;
          }

          mask <<= 1;
        }

        start++;

        or = 0;

        for (int i = MAX_BIT - 1; i >= 0; i--) {
          or = (or << 1) | (bit[i] == 0 ? 0 : 1);
        }
      }
    }

    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
