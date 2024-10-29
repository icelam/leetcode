class Solution {
  private int result;

  private void dfs(int[][] grid, int row, int column) {
    result = Math.max(result, column);

    if (result == grid[0].length - 1) {
      return;
    }

    for (int newRow = Math.max(row - 1, 0); newRow < Math.min(row + 2, grid.length); newRow++) {
      if (grid[newRow][column + 1] > grid[row][column]) {
        dfs(grid, newRow, column + 1);
      }
    }

    grid[row][column] = 0;
  }

  public int maxMoves(int[][] grid) {
    int height = grid.length;
    for (int row = 0; row < height; row++) {
      dfs(grid, row, 0);
    }

    return result;
  }
}
