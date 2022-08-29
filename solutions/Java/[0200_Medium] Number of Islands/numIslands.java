class Solution {
  private boolean isValidPosition(int y, int x, int height, int width) {
    return y >= 0 && y < height && x >= 0 && x < width;
  }

  private void visitIsland(char[][] grid, int y, int x, int height, int width) {
    if (!isValidPosition(y, x, height, width) || grid[y][x] == '0') {
      return;
    }

    grid[y][x] = '0';

    visitIsland(grid, y + 1, x, height, width);
    visitIsland(grid, y - 1, x, height, width);
    visitIsland(grid, y, x + 1, height, width);
    visitIsland(grid, y, x - 1, height, width);
  }

  public int numIslands(char[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

    int result = 0;

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (grid[y][x] == '1') {
          result++;
          visitIsland(grid, y, x, height, width);
        }
      }
    }

    return result;
  }
}
