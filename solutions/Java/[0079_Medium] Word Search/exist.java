class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  private boolean backtrack(char[][] board, int height, int width, String word, int n, StringBuilder sb, int row, int column, int index) {
    if (
      board[row][column] == '.'
      || board[row][column] != word.charAt(index)
    ) {
      return false;
    }

    if (index == n - 1) {
      return true;
    }

    char c = board[row][column];
    boolean isWordExists = false;

    board[row][column] = '.';
    sb.append(c);

    for (int[] d: directions) {
      int newRow = row + d[0];
      int newColumn = column + d[1];

      if (!isValidPosition(newRow, newColumn, height, width)) {
        continue;
      }

      boolean result = backtrack(board, height, width, word, n, sb, newRow, newColumn, index + 1);

      if (result) {
        isWordExists = true;
        break;
      }
    }

    sb.deleteCharAt(sb.length() - 1);
    board[row][column] = c;
    return isWordExists;
  }

  public boolean exist(char[][] board, String word) {
    int height = board.length;
    int width = board[0].length;

    char prefix = word.charAt(0);

    for (int i  = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        boolean isWordExist = backtrack(board, height, width, word, word.length(), new StringBuilder(board[i][j]), i, j, 0);

        if (isWordExist) {
          return true;
        }
      }
    }

    return false;
  }
}
