class Solution {
  public String longestPalindrome(String s) {
    int n = s.length();
    int start = 0;
    int end = 0;
    boolean[][] dp = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j + i < n; j++) {
        dp[j][j + i] = s.charAt(j) == s.charAt(j + i) && (i < 2 || dp[j + 1][j + i - 1]);
        if (dp[j][j + i] && i > end - start) {
          start = j;
          end = j + i;
        }
      }
    }

    return s.substring(start, end + 1);
  }
}
