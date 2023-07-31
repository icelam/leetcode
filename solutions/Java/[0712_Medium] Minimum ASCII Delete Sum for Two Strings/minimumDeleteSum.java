class Solution {
  public int minimumDeleteSum(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      dp[i][0] = dp[i - 1][0] + c1[i - 1];
    }

    for (int j = 1; j <= n; j++) {
      dp[0][j] = dp[0][j - 1] + c2[j - 1];
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (c1[i - 1] == c2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(c1[i - 1] + dp[i - 1][j], c2[j - 1] + dp[i][j - 1]);
        }
      }
    }

    return dp[m][n];
  }
}
