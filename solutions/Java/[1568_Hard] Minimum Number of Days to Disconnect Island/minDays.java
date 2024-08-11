class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int y, int x, int height, int width) {
    return y >= 0 && y < height && x >= 0 && x < width;
  }

  private void visitIsland(int[][] grid, int y, int x, int height, int width) {
    if (!isValidPosition(y, x, height, width) || grid[y][x] != 1) {
      return;
    }

    grid[y][x] = 2;

    for (int[] d: directions) {
      visitIsland(grid, y + d[0], x + d[1], height, width);
    }
  }

  private void unvisitIsland(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (grid[y][x] == 2) {
          grid[y][x] = 1;
        }
      }
    }
  }

  private int countIslands(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

    int count = 0;

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (grid[y][x] == 1) {
          count++;
          visitIsland(grid, y, x, height, width);
        }
      }
    }

    unvisitIsland(grid);
    return count;
  }

  public int minDays(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

     /**
     * The answe can only be either 0, 1, 2 for this problem since it is asking for "shortest path":
    * Scenario 1:
    *  - There exists 1 row or column which has only one land grid
    *  - It takes one day to disconnect
    * Scenario 2:
    * - There is no row or column having only 1 land grid
    * - We can pick any land grid located at any corner of the island to diconnect
    * - It takes 2 days to disconnect
    * Scenario 3:
    * - If there is 0 or more than 1 island, it is considered diconnected,
    * - It takes 0 days to disconnect
    */

    // Handle scenario 3
    if (countIslands(grid) != 1) {
      return 0;
    }

    // Backtrack: Select every cell of land and try to flood it,
    // after flooding the land, check if island is disconnected or not
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (grid[y][x] == 1) {
          grid[y][x] = 0;

          if (countIslands(grid) != 1) {
            return 1;
          }

          grid[y][x] = 1;
        }
      }
    }

    return 2;
  }
}
