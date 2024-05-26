class Solution {
  private static int MOD = (int) (1e9 + 7);

  private int dfs(int day, int n, int absent, int late, int[][][] memo) {
    if (day == n) {
      return 1;
    }

    if (memo[day][absent][late] != 0) {
      return memo[day][absent][late];
    }

    int result = 0;

    // 1. Random placing present 'P'
    result += dfs(day + 1, n, absent, 0, memo);
    result %= MOD;

    // 2. Absent 'A' can only be placed at most 1 time
    if (absent < 1) {
      result += dfs(day + 1, n, 1, 0, memo);
      result %= MOD;
    }

    // 3. At most 2 consecutive late 'L' days
    if (late < 2) {
      result += dfs(day + 1, n, absent, late + 1, memo);
      result %= MOD;
    }

    memo[day][absent][late] = result;
    return result;
  }

  public int checkRecord(int n) {
    // state variables:
    // 1. Day: n
    // 2. Absent: At most 1 day in total
    // 3. Late: At most 2 consecutive days
    int[][][] memo = new int[n][2][3];
    return dfs(0, n, 0, 0, memo);
  }
}
