class Solution {
  public String shortestCommonSupersequence(String str1, String str2) {
    int m = str1.length();
    int n = str2.length();
    char[] characters1 = str1.toCharArray();
    char[] characters2 = str2.toCharArray();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (characters1[i - 1] == characters2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    StringBuilder builder = new StringBuilder();
    int i = m;
    int j = n;

    while (i > 0 && j > 0) {
      if (characters1[i - 1] == characters2[j - 1]) {
        builder.append(characters1[i - 1]);
        i--;
        j--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        builder.append(characters1[i - 1]);
        i--;
      } else {
        builder.append(characters2[j - 1]);
        j--;
      }
    }

    while (i > 0) {
      builder.append(characters1[i - 1]);
      i--;
    }

    while (j > 0) {
      builder.append(characters2[j - 1]);
      j--;
    }

    return builder.reverse().toString();
  }
}
