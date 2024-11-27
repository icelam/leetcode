class Solution {
  public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
    int m = queries.length;
    List<Integer>[] from = new ArrayList[n];
    Arrays.setAll(from, (i) -> new ArrayList<>());

    int[] dp = new int[n];
    for (int i = 1; i < n; i++) {
      dp[i] = i;
    }

    int[] result = new int[m];

    for (int q = 0; q < m; q++) {
      int left = queries[q][0];
      int right = queries[q][1];
      from[right].add(left);

      if (dp[left] + 1 < dp[right]) {
        dp[right] = dp[left] + 1;

        for (int i = right + 1; i < n; i++) {
          dp[i] = Math.min(dp[i], dp[i - 1] + 1);

          for (int j : from[i]) {
            dp[i] = Math.min(dp[i], dp[j] + 1);
          }
        }
      }

      result[q] = dp[n - 1];
    }

    return result;

  }
}
