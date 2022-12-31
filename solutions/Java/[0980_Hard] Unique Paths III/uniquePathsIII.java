class Solution {
  private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private enum Tile {
    START(1), END(2), EMPTY(0), WALL(-1);
    private final int value;

    private Tile(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public int findUniquePaths(int[][] grid, int row, int column, int height, int width, int requiredMoves, int movesTaken) {
    if (
      !isValidPosition(row, column, height, width)
      || grid[row][column] == Tile.WALL.getValue()
    ) {
      return 0;
    }

    int currentGrid = grid[row][column];

    if (currentGrid == Tile.END.getValue()) {
      return requiredMoves == movesTaken ? 1 : 0;
    }

    grid[row][column] = -1;

    int result = 0;

    for (int[] d: directions) {
      int newRow = row + d[0];
      int newColumn = column + d[1];
      result += findUniquePaths(grid, newRow, newColumn, height, width, requiredMoves, movesTaken + 1);
    }

    grid[row][column] = currentGrid;

    return result;
  }

  public int uniquePathsIII(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int[] startingPosition = new int[2];
    int requiredMoves = 0;

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (grid[row][column] == Tile.START.getValue()) {
          startingPosition[0] = row;
          startingPosition[1] = column;
        }

        if (
          grid[row][column] == Tile.EMPTY.getValue()
          || grid[row][column] == Tile.END.getValue()
        ) {
          requiredMoves++;
        }
      }
    }

    return findUniquePaths(grid, startingPosition[0], startingPosition[1], height, width, requiredMoves, 0);
  }
}
