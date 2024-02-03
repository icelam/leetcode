class Solution {
  public int maxSumAfterPartitioning(int[] arr, int k) {
    int n = arr.length;
    int[] dp = new int[n + 1];

    for (int i = n - 1; i >= 0; i--) {
      int max = 0;

      for (int j = i; j < i + k && j < n; j++) {
        max = Math.max(max, arr[j]);
        dp[i] = Math.max(dp[i], dp[j + 1] + max * (j - i + 1));
      }
    }

    return dp[0];
  }
}
