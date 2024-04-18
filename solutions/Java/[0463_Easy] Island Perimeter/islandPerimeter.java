class Solution {
  private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  private int dfs(int[][] grid, int row, int column, int height, int width) {
    if (!isValidPosition(row, column, height, width) || grid[row][column] == 0) {
      return 1;
    }

    if (grid[row][column] == -1) {
      return 0;
    }

    grid[row][column] = -1;

    int perimeter = 0;

    for (int[] d: directions) {
      perimeter += dfs(grid, row + d[0], column + d[1], height, width);
    }

    return perimeter;
  }

  public int islandPerimeter(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (grid[row][column] == 1) {
          return dfs(grid, row, column, height, width);
        }
      }
    }

    return 0;
  }
}
