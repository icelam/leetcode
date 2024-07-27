class Solution {
  public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
    // Floyd-Warshall Algorithm
    int[][] distanceMatrix = new int[26][26];

    for (int i = 0; i < 26; i++) {
      Arrays.fill(distanceMatrix[i], Integer.MAX_VALUE / 2);
      distanceMatrix[i][i] = 0;
    }

    for (int i = 0; i < cost.length; i++) {
      int x = original[i] - 'a';
      int y = changed[i] - 'a';
      distanceMatrix[x][y] = Math.min(distanceMatrix[x][y], cost[i]);
    }

    for (int k = 0; k < 26; k++) {
      for (int i = 0; i < 26; i++) {
        for (int j = 0; j < 26; j++) {
          distanceMatrix[i][j] = Math.min(distanceMatrix[i][j], distanceMatrix[i][k] + distanceMatrix[k][j]);
        }
      }
    }

    long result = 0;

    for (int i = 0; i < source.length(); i++) {
      int distance = distanceMatrix[source.charAt(i) - 'a'][target.charAt(i) - 'a'];

      if (distance == Integer.MAX_VALUE / 2) {
        return -1;
      }

      result += distance;
    }

    return result;
  }
}
