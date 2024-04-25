class Solution {
  public int longestIdealString(String s, int k) {
    int[] dp = new int[26];
    int result = 0;

    for (char c: s.toCharArray()) {
      int i = c - 'a';

      for (int j = Math.max(i - k, 0); j < 26 && j <= i + k; j++) {
        dp[i] = Math.max(dp[i], dp[j]);
      }

      dp[i]++;
      result = Math.max(result, dp[i]);
    }

    return result;
  }
}
