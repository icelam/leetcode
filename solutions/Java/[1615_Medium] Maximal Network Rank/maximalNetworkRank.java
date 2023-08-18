class Solution {
  public int maximalNetworkRank(int n, int[][] roads) {
    boolean[][] isConnected = new boolean[n][n];
    int[] roadCount = new int[n];

    for (int[] road: roads) {
      isConnected[road[0]][road[1]] = true;
      isConnected[road[1]][road[0]] = true;
      roadCount[road[0]]++;
      roadCount[road[1]]++;
    }

    int result = 0;

    for (int city1 = 0; city1 < n; city1++) {
      for (int city2 = city1 + 1; city2 < n; city2++) {
        int currentRank = roadCount[city1] + roadCount[city2];

        if (isConnected[city1][city2]) {
          currentRank--;
        }

        result = Math.max(result, currentRank);
      }
    }

    return result;
  }
}
