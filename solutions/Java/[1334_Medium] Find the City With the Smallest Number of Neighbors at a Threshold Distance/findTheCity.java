class Solution {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    // Floyd-Warshall Algorithm
    int[] result = {Integer.MAX_VALUE / 2, -1};
    int[][] distanceMatrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(distanceMatrix[i], Integer.MAX_VALUE / 2);
    }

    for (int[] currentEdge: edges) {
      int from = currentEdge[0];
      int to = currentEdge[1];
      int weight = currentEdge[2];

      distanceMatrix[from][to] = weight;
      distanceMatrix[to][from] = weight;
    }

    for (int k = 0; k < n; k++) {
      distanceMatrix[k][k] = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          distanceMatrix[i][j] = Math.min(distanceMatrix[i][j], distanceMatrix[i][k] + distanceMatrix[k][j]);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      int count = 0;

      for (int j = 0; j < n; j++) {
        if (distanceMatrix[i][j] <= distanceThreshold) {
          count++;
        }
      }

      if (count <= result[0]) {
        result[0] = count;
        result[1] = i;
      }
    }

    return result[1];
  }
}
