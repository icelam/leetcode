class Solution {
  private enum GridStatus {
    IS_GUARDED,
    HAS_WALL,
    HAS_GUARD,
  }

  public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
    int remainingGrids = 0;
    GridStatus[][] grid = new GridStatus[m][n];

    for (int[] position: walls) {
      int row = position[0];
      int column = position[1];
      grid[row][column] = GridStatus.HAS_WALL;
    }

    for (int[] position: guards) {
      int row = position[0];
      int column = position[1];
      grid[row][column] = GridStatus.HAS_GUARD;
    }

    for (int[] position: guards) {
      int row = position[0];
      int column = position[1];

      for (int newRow = row - 1; newRow >= 0; newRow--) {
        if (grid[newRow][column] == GridStatus.HAS_WALL || grid[newRow][column] == GridStatus.HAS_GUARD) {
          break;
        }
        grid[newRow][column] = GridStatus.IS_GUARDED;
      }

      for (int newRow = row + 1; newRow < grid.length; newRow++) {
        if (grid[newRow][column] == GridStatus.HAS_WALL || grid[newRow][column] == GridStatus.HAS_GUARD) {
          break;
        }
        grid[newRow][column] = GridStatus.IS_GUARDED;
      }

      for (int newColumn = column - 1; newColumn >= 0; newColumn--) {
        if (grid[row][newColumn] == GridStatus.HAS_WALL || grid[row][newColumn] == GridStatus.HAS_GUARD) {
          break;
        }
        grid[row][newColumn] = GridStatus.IS_GUARDED;
      }

      for (int newColumn = column + 1; newColumn < grid[0].length; newColumn++) {
        if (grid[row][newColumn] == GridStatus.HAS_WALL || grid[row][newColumn] == GridStatus.HAS_GUARD) {
          break;
        }
        grid[row][newColumn] = GridStatus.IS_GUARDED;
      }
    }

    for (int row = 0; row < m; row++) {
      for (int column = 0; column < n; column++) {
        if (grid[row][column] == null) {
          remainingGrids++;
        }
      }
    }

    return remainingGrids;
  }
}
