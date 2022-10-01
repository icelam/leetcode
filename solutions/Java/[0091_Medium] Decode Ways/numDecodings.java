class Solution {
  public int numDecodings(String s) {
    char[] c = s.toCharArray();
    int length = c.length;
    int[] dp = new int[length + 1];
    dp[0] = 1;

    for (int i = 0; i < length; i++) {
      if (c[i] != '0') {
        dp[i + 1] += dp[i];
      }

      if (
        i >= 1
        && (c[i - 1] == '1' || c[i - 1] == '2' && c[i] <= '6')
      ) {
        dp[i + 1] += dp[i - 1];
      }
    }

    return dp[length];
  }
}
