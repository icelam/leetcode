class Solution {
  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row <= height - 1 && column >= 0 && column <= width - 1;
  }

  public int countIslandSize(int[][] grid, int row, int column) {
    if (
      !isValidPosition(row, column, grid.length, grid[0].length)
      || grid[row][column] != 1
    ) {
      return 0;
    }

    grid[row][column] = -1;

    return (
      1
      + countIslandSize(grid, row - 1, column)
      + countIslandSize(grid, row + 1, column)
      + countIslandSize(grid, row, column - 1)
      + countIslandSize(grid, row, column + 1)
    );
  }

  public int maxAreaOfIsland(int[][] grid) {
    int max = 0;

    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[0].length; column++) {
        if (grid[row][column] == 1) {
          max = Math.max(max, countIslandSize(grid, row, column));
        }
      }
    }

    return max;
  }
}
