class Solution {
  public int mincostTickets(int[] days, int[] costs) {
    int n = days.length;
    int maxDay = days[n - 1];
    int[] dp = new int[maxDay + 1];
    int pointer = 0;

    for (int i = 1; i <= maxDay; i++) {
      if (days[pointer] == i) {
        dp[i] = dp[Math.max(i - 1, 0)] + costs[0];
        dp[i] = Math.min(dp[i], dp[Math.max(i - 7, 0)] + costs[1]);
        dp[i] = Math.min(dp[i], dp[Math.max(i - 30, 0)] + costs[2]);
        pointer++;
      } else {
        dp[i] = dp[i - 1];
      }
    }

    return dp[maxDay];
  }
}
