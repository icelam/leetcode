public class Solution {
  public int numberOfArithmeticSlices(int[] nums) {
    int n = nums.length;

    if (n < 3) {
      return 0;
    }

    Map<Long, Integer>[] dp = new HashMap[n];

    for (int i = 0; i < n; i++) {
      dp[i] = new HashMap<>();
    }

    int result = 0;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        long delta = (long) nums[i] - nums[j];

        if (delta > Integer.MAX_VALUE || delta < Integer.MIN_VALUE) {
          continue;
        }

        dp[i].put(delta, dp[i].getOrDefault(delta, 0) + dp[j].getOrDefault(delta, 0) + 1);

        if (dp[j].containsKey(delta)) {
          result += dp[j].get(delta);
        }
      }
    }
    return result;
  }
}
