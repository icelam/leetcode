class Solution {
  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row <= height - 1 && column >= 0 && column <= width - 1;
  }

  public int orangesRotting(int[][] grid) {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int freshOrangeCount = 0;
    int minutesPassed = 0;
    Queue<int[]> rottingOranges = new LinkedList<>();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          rottingOranges.add(new int[]{i, j});
        } else if (grid[i][j] == 1) {
          freshOrangeCount++;
        }
      }
    }

    while (freshOrangeCount > 0 && !rottingOranges.isEmpty()) {
      int currentBatchSize = rottingOranges.size();

      for (int k = 0; k < currentBatchSize; k++) {
        int[] position = rottingOranges.remove();
        int currentRow = position[0];
        int currentColumn = position[1];

        for (int[] d: directions) {
          int newRow = currentRow + d[0];
          int newColumn = currentColumn + d[1];

          if (
            isValidPosition(newRow, newColumn, grid.length, grid[0].length)
            && grid[newRow][newColumn] == 1
          ) {
            grid[newRow][newColumn] = 2;
            rottingOranges.add(new int[]{newRow, newColumn});
            freshOrangeCount--;
          }
        }
      }

      minutesPassed++;
    }

    return freshOrangeCount > 0 ? -1 : minutesPassed;
  }
}
