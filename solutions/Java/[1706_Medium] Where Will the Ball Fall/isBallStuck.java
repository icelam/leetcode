class Solution {
  private boolean isBallStuck(int[][] grid, int height, int width, int row, int column) {
    boolean ballTowardsRightIsStuck = (
      grid[row][column] == 1 && (column == width - 1 || grid[row][column + 1] == -1)
    );

    boolean ballTowardsLeftIsStuck = (
      grid[row][column] == -1 && (column == 0 || grid[row][column - 1] == 1)
    );

    return ballTowardsRightIsStuck || ballTowardsLeftIsStuck;
  }

  private int dfs(int[][] grid, int height, int width, int row, int column) {
    if (isBallStuck(grid, height, width, row, column)) {
      return -1;
    }

    if (row == height - 1) {
      return column + grid[row][column];
    }

    return dfs(grid, height, width, row + 1, column + grid[row][column]);
  }

  public int[] findBall(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int[] result = new int[width];

    for (int i = 0; i < width; i++) {
      result[i] = dfs(grid, height, width, 0, i);
    }

    return result;
  }
}
