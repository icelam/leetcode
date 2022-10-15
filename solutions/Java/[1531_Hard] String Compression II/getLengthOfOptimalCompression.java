class Solution {
  private int dfs(Integer[][] dp, char[] c, int index, int k) {
    if (k < 0) {
      return c.length;
    }

    if (index + k >= c.length) {
      return 0;
    }

    if (dp[index][k] != null) {
      return dp[index][k];
    }

    int result = Integer.MAX_VALUE;

    result = dfs(dp, c, index + 1, k - 1);

    int length = 0;
    int sameChar = 0;
    int differentChar = 0;

    for (int j = index; j < c.length && differentChar <= k; j++) {
      if (c[index] == c[j]) {
        sameChar++;

        if (sameChar <= 2 || sameChar == 10 || sameChar == 100) {
          length++;
        }
      } else {
        differentChar++;
      }

      result = Math.min(result, length + dfs(dp, c, j + 1, k - differentChar));
    }

    dp[index][k] = result;

    return result;
  }

  public int getLengthOfOptimalCompression(String s, int k) {
    char[] c = s.toCharArray();
    int length = c.length;
    Integer[][] dp = new Integer[length][k + 1];
    return dfs(dp, c, 0, k);
  }
}
