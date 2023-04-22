class Solution {
  public char[] copyAndReverse(char[] characters) {
    int n = characters.length;
    char[] reversed = new char[n];

    for (int i = 0; i < n; i++) {
      reversed[n - i - 1] = characters[i];
    }

    return reversed;
  }

  public int longestCommonSubsequence(char[] characters1, char[] characters2, int n) {
    int[][] dp = new int[n + 1][n + 1];
    for (int i = 0; i < n; i++) {
      int c1 = characters1[i];

      for (int j = 0; j < n; j++) {
        int c2 = characters2[j];

        if (c1 == c2) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
        } else {
          dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        }
      }
    }

    return dp[n][n];
  }

  public int minInsertions(String s) {
    int n = s.length();
    char[] characters = s.toCharArray();
    char[] reversedCharacters = copyAndReverse(characters);
    return n - longestCommonSubsequence(characters, reversedCharacters, n);
  }
}
