class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  private int catchFish(int[][] grid, int row, int column, int height, int width) {
    if (!isValidPosition(row, column, height, width) || grid[row][column] == 0) {
      return 0;
    }

    int totalFish = grid[row][column];
    grid[row][column] = 0;

    for (int[] d: directions) {
      totalFish += catchFish(grid, row + d[0], column + d[1], height, width);
    }

    return totalFish;
  }

  public int findMaxFish(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

    int result = 0;

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (grid[row][column] > 0) {
          result = Math.max(result, catchFish(grid, row, column, height, width));
        }
      }
    }

    return result;
  }
}
