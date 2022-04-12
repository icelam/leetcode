class Solution {
  private final int ALIVE = 1;
  private final int DEAD = 0;
  private final int DYING = -1;
  private final int REVIVING = 2;

  public boolean isValidNeighbor(int row, int column, int rowOffest, int columnOffset, int rowSize, int columnSize) {
    return (
      !(row + rowOffest == row && column + columnOffset == column)
      && (row + rowOffest >= 0 && row + rowOffest < rowSize)
      && (column + columnOffset >= 0 && column + columnOffset < columnSize)
    );
  }

  public int countNeighborsAlive(int row, int column, int[][] board) {
    int rowSize = board.length;
    int columnSize = board[0].length;

    int aliveNeighbors = 0;

    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if (
          isValidNeighbor(row, column, i, j, rowSize, columnSize)
          && (board[row + i][column + j] == ALIVE || board[row + i][column + j] == DYING)
        ) {
          aliveNeighbors++;
        }
      }
    }

    return aliveNeighbors;
  }

  public int calculateNewState(int row, int column, int[][] board) {
    if (board[row][column] == DYING || board[row][column] == REVIVING) {
      return board[row][column];
    }

    int aliveNeighbors = countNeighborsAlive(row, column, board);

    if (board[row][column] == ALIVE) {
      return aliveNeighbors < 2 || aliveNeighbors > 3 ? DYING : ALIVE;
    }

    return aliveNeighbors == 3 ? REVIVING : DEAD;
  }

  public int transitToNewState(int row, int column, int[][] board) {
    if (board[row][column] == ALIVE || board[row][column] == DEAD) {
      return board[row][column];
    }

    if (board[row][column] == REVIVING) {
      return ALIVE;
    }

    return DEAD;
  }

  public void gameOfLife(int[][] board) {
    int rowSize = board.length;
    int columnSize = board[0].length;

    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < columnSize; j++) {
        board[i][j] = calculateNewState(i, j, board);
      }
    }

    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < columnSize; j++) {
        board[i][j] = transitToNewState(i, j, board);
      }
    }
  }
}
