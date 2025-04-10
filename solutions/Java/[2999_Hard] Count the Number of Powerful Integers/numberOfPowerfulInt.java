class Solution {
  private long dfs(int i, boolean limitLow, boolean limitHigh, char[] low, char[] high, int limit, char[] characters, long[] memo) {
    if (i == high.length) {
      return 1;
    }

    if (!limitLow && !limitHigh && memo[i] != -1) {
      return memo[i];
    }

    int lo = limitLow ? low[i] - '0' : 0;
    int hi = limitHigh ? high[i] - '0' : 9;

    long result = 0;

    if (i < high.length - characters.length) {
      for (int d = lo; d <= Math.min(hi, limit); d++) {
        result += dfs(i + 1, limitLow && d == lo, limitHigh && d == hi, low, high, limit, characters, memo);
      }
    } else {
      int x = characters[i - (high.length - characters.length)] - '0';

      if (lo <= x && x <= Math.min(hi, limit)) {
        result = dfs(i + 1, limitLow && x == lo, limitHigh && x == hi, low, high, limit, characters, memo);
      }
    }

    if (!limitLow && !limitHigh) {
      memo[i] = result;
    }

    return result;
  }

  public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
    String high = Long.toString(finish);
    int n = high.length();

    String low = Long.toString(start);
    low = "0".repeat(n - low.length()) + low;

    long[] memo = new long[n];
    Arrays.fill(memo, -1);

    return dfs(0, true, true, low.toCharArray(), high.toCharArray(), limit, s.toCharArray(), memo);
  }
}
