class Solution {
  private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public int trapRainWater(int[][] heightMap) {
    int height = heightMap.length;
    int width = heightMap[0].length;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
    int result = 0;

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (row == 0 || row == height - 1 || column == 0 || column == width - 1) {
          pq.add(new int[] {heightMap[row][column], row, column});
          heightMap[row][column] = -1;
        }
      }
    }

    while (!pq.isEmpty()) {
      int[] t = pq.remove();
      int minHeight = t[0];
      int row = t[1];
      int column = t[2];

      for (int[] d: direction) {
        int newRow = row + d[0];
        int newColumn = column + d[1];

        if (isValidPosition(newRow, newColumn, height, width) && heightMap[newRow][newColumn] >= 0) {
          result += Math.max(minHeight - heightMap[newRow][newColumn], 0);
          pq.add(new int[] {Math.max(minHeight, heightMap[newRow][newColumn]), newRow, newColumn});
          heightMap[newRow][newColumn] = -1;
        }
      }
    }

    return result;
  }
}
