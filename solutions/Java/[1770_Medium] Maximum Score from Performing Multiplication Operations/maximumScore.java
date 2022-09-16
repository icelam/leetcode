class Solution {
  private int[][] memo;
  private int m;
  private int n;

  private int dp(int[] nums, int[] multipliers, int turn, int start) {
    if (turn == m) {
      return 0;
    }

    if (memo[turn][start] != Integer.MIN_VALUE) {
      return memo[turn][start];
    }

    int end = n - 1 - (turn - start);

    int scoreOfAttempt1 = nums[start] * multipliers[turn] + dp(nums, multipliers, turn + 1, start + 1);
    int scoreOfAttempt2 = nums[end] * multipliers[turn] + dp(nums, multipliers, turn + 1, start);

    memo[turn][start] = Math.max(scoreOfAttempt1, scoreOfAttempt2);
    return memo[turn][start];
  }

  public int maximumScore(int[] nums, int[] multipliers) {
    m = multipliers.length;
    n = nums.length;
    memo = new int[m][n];

    for (int[] turnMemo: memo) {
      Arrays.fill(turnMemo, Integer.MIN_VALUE);
    }

    return dp(nums, multipliers, 0, 0);
  }
}
