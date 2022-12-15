class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();

    int[][] dp = new int[m + 1][n + 1];

    char[] characters1 = text1.toCharArray();
    char[] characters2 = text2.toCharArray();

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (characters1[i - 1] == characters2[j - 1]) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[m][n];
  }
}
