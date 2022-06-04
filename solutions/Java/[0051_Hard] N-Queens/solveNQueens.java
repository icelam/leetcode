class Solution {
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
   * Generate N * N board with queens on it
   * @param  n  board size
   * @param  queens  queens[i] = queens is placed in [i]-column of i-th row
   * @return N * N board with queens on positions defined
   */
  public List<String> generateBoardWithQueens(int[] queens, int n) {
    List board = new ArrayList<String>();

    for (int i = 0; i < n; i++) {
      StringBuilder row = new StringBuilder();

      for (int j = 0; j < n; j++) {
        row.append(j == queens[i] ? 'Q' : '.');
      }

      board.add(row.toString());
    }

    return board;
  }

  /**
   * Backtrack function that generates boards that contains N queens,
   * which no two queens can attack each other
   * @param  n  board size
   * @param  rowId  current row the backtrack should check
   * @param  queens  queens[i] = queens is placed in [i]-column of i-th row
   * @param  result  list that holds all the valid boards
   */
  public void backtrack(int n, int rowId, int[] queens, List<List<String>> result) {
    if (rowId == n) {
      result.add(generateBoardWithQueens(queens, n));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!hasAttackableEnemies(queens, rowId, i)) {
        queens[rowId] = i;
        backtrack(n, rowId + 1, queens, result);
        queens[rowId] = -1;
      }
    }
  }

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<List<String>>();

    // n = 1 has only one possible solution
    if (n == 1) {
      result.add(Arrays.asList(new String[] {"Q"}));
    }

    // 2 - 3 is impossible to have queens not attacking each other
    // So we only perform backtrack on n >= 4
    if (n >= 4) {
      int[] queens = new int[n];
      backtrack(n, 0, queens, result);
    }

    return result;
  }
}
