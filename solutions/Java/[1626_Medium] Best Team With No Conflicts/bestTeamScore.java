class Solution {
  private int findMaxScore(int[][] players, int index, int previous, int[][] dp) {
    if (index >= players.length) {
      return 0;
    }

    if (dp[previous + 1][index] != -1) {
      return dp[previous + 1][index];
    }

    if (previous == -1 || players[index][1] >= players[previous][1]) {
      dp[previous + 1][index] = Math.max(
        findMaxScore(players, index + 1, previous, dp),
        players[index][1] + findMaxScore(players, index + 1, index, dp)
      );
      return dp[previous + 1][index];
    }

    dp[previous + 1][index] = findMaxScore(players, index + 1, previous, dp);
    return dp[previous + 1][index];
  }

  public int bestTeamScore(int[] scores, int[] ages) {
    int n = scores.length;
    int[][] players = new int[n][2];

    for (int i = 0; i < n; i++) {
      players[i][0] = ages[i];
      players[i][1] = scores[i];
    }

    Arrays.sort(players, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    int[][] dp = new int[n][n];

    for (int[] row: dp) {
      Arrays.fill(row, -1);
    }

    return findMaxScore(players, 0, -1, dp);
  }
}
