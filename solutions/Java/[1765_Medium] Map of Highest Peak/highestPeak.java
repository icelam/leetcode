class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public int[][] highestPeak(int[][] isWater) {
    int height = isWater.length;
    int width = isWater[0].length;
    int[][] result = new int[height][width];

    for (int[] row: result) {
      Arrays.fill(row, -1);
    }

    Queue<int[]> queue = new LinkedList<>();

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (isWater[row][column] == 1) {
          queue.add(new int[] {row, column});
          result[row][column] = 0;
        }
      }
    }

    int currentHeight = 1;

    while (!queue.isEmpty()) {
      int batchSize = queue.size();

      for (int i = 0; i < batchSize; i++) {
        int[] currentPosition = queue.remove();

        for (int[] d : directions) {
          int newRow = currentPosition[0] + d[0];
          int newColumn = currentPosition[1] + d[1];

          if (isValidPosition(newRow, newColumn, height, width) && result[newRow][newColumn] == -1) {
            result[newRow][newColumn] = currentHeight;
            queue.add(new int[] {newRow, newColumn});
          }
        }
      }

      currentHeight++;
    }

    return result;
  }
}
