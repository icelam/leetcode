class Solution {
  public int maxValueOfCoins(List<List<Integer>> piles, int k) {
    int n = piles.size();
    int result = 0;
    int[][] dp = new int[n + 1][k + 1];

    for (int i = 0; i < n; i++) {
      int sum = 0;

      List<Integer> currentPile = piles.get(i);

      for (int j = 0; j < currentPile.size(); j++) {
        sum += currentPile.get(j);

        for (int x = j + 1; x <= k; x++) {
          dp[i + 1][x] = Math.max(Math.max(dp[i][x], dp[i][x - 1 - j] + sum), dp[i + 1][x]);
          result = Math.max(result, dp[i + 1][x]);
        }
      }
    }
    return result;
  }
}
