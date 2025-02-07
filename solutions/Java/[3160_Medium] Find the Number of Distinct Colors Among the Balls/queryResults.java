class Solution {
  public int[] queryResults(int limit, int[][] queries) {
    int m = queries.length;
    int[] balls = new int[limit + 1];
    HashMap<Integer, Integer> frequency = new HashMap<>();
    int[] result = new int[queries.length];

    for (int i = 0; i < m; i++) {
      int ballIndex = queries[i][0];
      int newColor = queries[i][1];
      int oldColor = balls[ballIndex];
      int oldCount = frequency.getOrDefault(oldColor, 0);

      if (oldColor == newColor) {
        result[i] = frequency.keySet().size();
        continue;
      }

      if (oldCount == 1) {
        frequency.remove(oldColor);
      }

      if (oldCount > 1) {
        frequency.put(oldColor, oldCount - 1);
      }

      balls[ballIndex] = newColor;
      frequency.put(newColor, frequency.getOrDefault(newColor, 0) + 1);
      result[i] = frequency.keySet().size();
    }

    return result;
  }
}
