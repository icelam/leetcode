class Solution {
  public long gridGame(int[][] grid) {
    int n = grid[0].length;
    long firstRowSum = 0;
    long secondRowSum = 0;
    long minScore = Long.MAX_VALUE;

    for (int score: grid[0]) {
      firstRowSum += score;
    }

    for (int i = 0; i < n; i++) {
      firstRowSum -= grid[0][i];
      minScore = Math.min(minScore, Math.max(firstRowSum, secondRowSum));
      secondRowSum += grid[1][i];
    }

    return minScore;
  }
}
