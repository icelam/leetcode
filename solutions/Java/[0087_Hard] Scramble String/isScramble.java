class Solution {
  public boolean isScramble(String s1, String s2) {
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    int m = c1.length;
    int n = c2.length;

    if (m != n) {
      return false;
    }

    boolean[][][] dp = new boolean[m][m][m + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        dp[i][j][1] = c1[i] == c2[j];
      }
    }

    for (int length = 2; length <= m; length++) {
      for (int i = 0; i <= m - length; i++) {
        for (int j = 0; j <= m - length; j++) {
          for (int k = 1; k <= length - 1; k++) {
            if (dp[i][j][k] && dp[i + k][j + k][length - k]) {
              dp[i][j][length] = true;
              break;
            }

            if (dp[i][j + length - k][k] && dp[i + k][j][length - k]) {
              dp[i][j][length] = true;
              break;
            }
          }
        }
      }
    }

    return dp[0][0][m];
  }
}
