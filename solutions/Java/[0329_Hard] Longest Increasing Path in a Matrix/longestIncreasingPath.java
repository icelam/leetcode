class Solution {
  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public int longestIncreasingPath(int[][] matrix) {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int height = matrix.length;
    int width = matrix[0].length;
    int[][] outDegrees = new int[height][width];
    int result = 0;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int[] d: directions) {
          int neighborRow = i + d[0];
          int neighborColumn = j + d[1];
          if (
            isValidPosition(neighborRow, neighborColumn, height, width)
            && matrix[neighborRow][neighborColumn] > matrix[i][j]
          ) {
            outDegrees[i][j]++;
          }
        }
      }
    }

    Queue<int[]> queue = new LinkedList<int[]>();

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (outDegrees[i][j] == 0) {
          queue.add(new int[]{i, j});
        }
      }
    }

    while (!queue.isEmpty()) {
      result++;

      int batchSize = queue.size();

      for (int i = 0; i < batchSize; i++) {
        int[] cell = queue.remove();
        int row = cell[0];
        int column = cell[1];

        for (int[] d: directions) {
          int neighborRow = row + d[0];
          int neighborColumn = column + d[1];
          if (
            isValidPosition(neighborRow, neighborColumn, height, width)
            && matrix[neighborRow][neighborColumn] < matrix[row][column]
          ) {
            outDegrees[neighborRow][neighborColumn]--;

            if (outDegrees[neighborRow][neighborColumn] == 0) {
              queue.add(new int[]{neighborRow, neighborColumn});
            }
          }
        }
      }
    }

    return result;
  }
}
