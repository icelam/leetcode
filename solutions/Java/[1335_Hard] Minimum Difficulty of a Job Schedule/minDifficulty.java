class Solution {
  public int minDifficulty(int[] jobDifficulty, int d) {
    int numberOfJobs = jobDifficulty.length;

    if (numberOfJobs < d) {
      return -1;
    }

    int[][] memo = new int[numberOfJobs][d + 1];

    for (int[] row: memo) {
      Arrays.fill(row, 300001);
    }

    memo[0][1] = jobDifficulty[0];

    for (int i = 1; i < numberOfJobs; i++) {
      int[] max = new int[i + 1];
      max[i] = jobDifficulty[i];

      for (int j = i - 1; j >= 0; j--) {
        max[j] = Math.max(max[j + 1], jobDifficulty[j]);
      }

      for (int k = Math.min(i + 1, d); k > 1; k--) {
        for (int l = 0; l < i; l++) {
          memo[i][k] = Math.min(memo[i][k], memo[l][k - 1] + max[l + 1]);
        }
      }

      memo[i][1] = max[0];
    }
    return memo[numberOfJobs - 1][d];
  }
}
