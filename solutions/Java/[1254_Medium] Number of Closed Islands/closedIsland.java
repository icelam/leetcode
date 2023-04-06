class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int y, int x, int height, int width) {
    return y >= 0 && y < height && x >= 0 && x < width;
  }

  private boolean dfs(int[][] grid, int y, int x, int height, int width) {
    if (!isValidPosition(y, x, height, width)) {
      return false;
    }

    if (grid[y][x] == 1) {
      return true;
    }

    grid[y][x] = 1;

    boolean isClosed = true;

    // For loop must be performed instead of short circuit here
    // As remaining island after short circuit will causes program to count same island twice
    for (int[] d: directions) {
      isClosed = isClosed && dfs(grid, y + d[0],  x + d[1], height, width);
    }

    return isClosed;
  }

  public int closedIsland(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

    int result = 0;

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (grid[y][x] == 0 && dfs(grid, y, x, height, width)) {
          result++;
        }
      }
    }

    return result;
  }
}
