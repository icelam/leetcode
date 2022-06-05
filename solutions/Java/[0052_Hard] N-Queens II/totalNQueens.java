class Solution {
  private int count;

  /**
   * Helper function of generateBoards() to check whether a position is valid to have a queen.
   * Since generateBoards() backtracks a row one at a time starting from 0,
   * it is safe to only check `i < row`
   * @param  queens  queens[i] = queens is placed in [i]-column of i-th row
   * @param  row  Row ID where the queen will be placed
   * @param  column  Column ID where the queen will be placed
   * @return  Whether the provided row column pair has enemies in it's movable range
   */
  public boolean hasAttackableEnemies(int[] queens, int row, int column) {
    for (int i = 0; i < row; i++) {
      int j = queens[i];

      if (i == row || j == column || Math.abs(row - i) == Math.abs(column - j)) {
        return true;
      }
    }

    return false;
  }

  /**
   * Backtrack function that generates boards that contains N queens,
   * which no two queens can attack each other
   * @param  n  board size
   * @param  rowId  current row the backtrack should check
   * @param  queens  queens[i] = queens is placed in [i]-column of i-th row
   * @param  result  list that holds all the valid boards
   */
  public void backtrack(int n, int rowId, int[] queens) {
    if (rowId == n) {
      count++;
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!hasAttackableEnemies(queens, rowId, i)) {
        queens[rowId] = i;
        backtrack(n, rowId + 1, queens);
        queens[rowId] = -1;
      }
    }
  }

  public int totalNQueens(int n) {
    count = 0;

    // 1 has only 1 possible solution
    if (n == 1) {
      return 1;
    }

    // 2 - 3 is impossible to have queens not attacking each other
    // So we only perform backtrack on n >= 4
    if (n == 2 || n == 3) {
      return 0;
    }

    int[] queens = new int[n];
    backtrack(n, 0, queens);
    return count;
  }
}
