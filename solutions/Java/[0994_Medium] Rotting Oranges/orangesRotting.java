class Solution {
  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row <= height - 1 && column >= 0 && column <= width - 1;
  }

  public void addNeighborToQueue(int[][] grid, int row, int column, Queue<int[]> queue) {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for (int[] d: directions) {
      int newRow = row + d[0];
      int newColumn = column + d[1];

      if (
        isValidPosition(newRow, newColumn, grid.length, grid[0].length)
        && grid[newRow][newColumn] == 1
      ) {
        queue.add(new int[]{newRow, newColumn});
      }
    }
  }

  public int orangesRotting(int[][] grid) {
    int freshOrangeCount = 0;
    int minutesPassed = 0;
    Queue<int[]> rottingOranges = new LinkedList<>();


    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          addNeighborToQueue(grid, i, j, rottingOranges);
        } else if (grid[i][j] == 1) {
          freshOrangeCount++;
        }
      }
    }

    while (!rottingOranges.isEmpty()) {
      int currentBatchSize = rottingOranges.size();
      Queue<int[]> newRottingOranges = new LinkedList<>();
      int rottenedOrangeCount = 0;

      for (int k = 0; k < currentBatchSize; k++) {
        int[] position = rottingOranges.remove();
        int currentRow = position[0];
        int currentColumn = position[1];

        if (grid[currentRow][currentColumn] == 2) {
          continue;
        }

        grid[currentRow][currentColumn] = 2;
        freshOrangeCount--;
        rottenedOrangeCount++;

        addNeighborToQueue(grid, currentRow, currentColumn, newRottingOranges);
      }

      rottingOranges = newRottingOranges;

      if (rottenedOrangeCount > 0) {
        minutesPassed++;
      }
    }

    return freshOrangeCount > 0 ? -1 : minutesPassed;
  }
}
