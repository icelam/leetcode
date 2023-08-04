class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    Set<String> wordSet = new HashSet<>(wordDict);

    boolean[] dp = new boolean[n + 1];
    dp[0] = true;

    for (int right = 1; right <= n; right++) {
      for (int left = 0; left < right; left++) {
        String segment = s.substring(left, right);

        if (dp[left] && wordSet.contains(segment)) {
          dp[right] = true;
        }
      }
    }

    return dp[n];
  }
}
