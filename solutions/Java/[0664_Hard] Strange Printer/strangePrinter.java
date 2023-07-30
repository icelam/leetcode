class Solution {
  public int strangePrinter(String s) {
    char[] characters = s.toCharArray();
    int n = characters.length;
    int[][] dp = new int[n][n];

    for (int i = n - 1; i >= 0; i--) {
      dp[i][i] = 1;

      for (int j = i + 1; j < n; ++j) {
        if (characters[i] == characters[j]) {
          dp[i][j] = dp[i][j - 1];
        } else {
          dp[i][j] = Integer.MAX_VALUE;

          for (int k = i; k < j; ++k) {
            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
          }
        }
      }
    }

    return dp[0][n - 1];
  }
}
