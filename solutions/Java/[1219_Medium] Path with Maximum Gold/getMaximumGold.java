class Solution {
  private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private int result;

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  private void dfs(int[][] grid, int width, int height, int row, int column, int goldAcquired) {
    if (!isValidPosition(row, column, height, width) || grid[row][column] == 0) {
      result = Math.max(result, goldAcquired);
      return;
    }

    int currentGold = grid[row][column];
    goldAcquired += currentGold;
    grid[row][column] = 0;

    for (int[] d: directions) {
      dfs(grid, width, height, row + d[0], column + d[1], goldAcquired);
    }

    grid[row][column] = currentGold;
  }

  public int getMaximumGold(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    result = 0;

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (grid[row][column] > 0) {
          dfs(grid, width, height, row, column, 0);
        }
      }
    }

    return result;
  }
}
