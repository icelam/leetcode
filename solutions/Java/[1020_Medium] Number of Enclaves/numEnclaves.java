class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int y, int x, int height, int width) {
    return y >= 0 && y < height && x >= 0 && x < width;
  }

  private void dfs(int[][] grid, int y, int x, int height, int width) {
    if (!isValidPosition(y, x, height, width) || grid[y][x] == 0 || grid[y][x] == -1) {
      return;
    }

    grid[y][x] = -1;

    for (int[] d: directions) {
      dfs(grid, y + d[0],  x + d[1], height, width);
    }
  }

  public int numEnclaves(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

    for (int y = 0; y < height; y++) {
      dfs(grid, y, 0, height, width);
      dfs(grid, y, width - 1, height, width);
    }

    for (int x = 0; x < width; x++) {
      dfs(grid, 0, x, height, width);
      dfs(grid, height - 1, x, height, width);
    }

    int result = 0;

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (grid[y][x] == 1) {
          result++;
        }
      }
    }

    return result;
  }
}
