class Solution {
  private static int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public int[] maxPoints(int[][] grid, int[] queries) {
    int k = queries.length;
    int height = grid.length;
    int width = grid[0].length;

    Integer[] queryIndices = new Integer[k];

    for (int i = 0; i < k; i++) {
      queryIndices[i] = i;
    }

    Arrays.sort(queryIndices, (a, b) -> queries[a] - queries[b]);

    int[] result = new int[k];
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    int score = 0;

    pq.add(new int[] {grid[0][0], 0, 0});
    grid[0][0] = 0;

    for (int i : queryIndices) {
      while (!pq.isEmpty() && pq.peek()[0] < queries[i]) {
        score++;

        int[] cellInformation = pq.remove();

        for (int[] d : directions) {
          int newRow = cellInformation[1] + d[0];
          int newColumn = cellInformation[2] + d[1];

          if (isValidPosition(newRow, newColumn, height, width) && grid[newRow][newColumn] > 0) {
            pq.add(new int[] {grid[newRow][newColumn], newRow, newColumn});
            grid[newRow][newColumn] = 0;
          }
        }
      }

      result[i] = score;
    }
    return result;
  }
}
