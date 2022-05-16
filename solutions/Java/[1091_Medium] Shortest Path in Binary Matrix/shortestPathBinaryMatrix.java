class Solution {
  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row <= height - 1 && column >= 0 && column <= width - 1;
  }

  public int shortestPathBinaryMatrix(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

    if (grid[0][0] == 1 || grid[height - 1][width - 1] == 1) {
      return -1;
    }

    int[][] directions = new int[][]{
      {-1, -1},
      {-1, 0},
      {-1, 1},
      {0, -1},
      {0, 1},
      {1, -1},
      {1, 0},
      {1, 1},
    };

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0, 1});

    while (!queue.isEmpty()) {
      int currentBatchSize = queue.size();

      for (int i = 0; i < currentBatchSize; i++) {
        int[] position = queue.remove();
        int currentRow = position[0];
        int currentColumn = position[1];
        int depth = position[2];

        if (currentRow == height - 1 && currentColumn == width - 1) {
          return depth;
        }

        for (int[] d: directions) {
          int newRow = currentRow + d[0];
          int newColumn = currentColumn + d[1];

          if (
            isValidPosition(newRow, newColumn, height, width)
            && grid[newRow][newColumn] == 0
          ) {
            grid[newRow][newColumn] = -1;
            queue.add(new int[]{newRow, newColumn, depth + 1});
          }
        }
      }
    }

    return -1;
  }
}
