class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  private boolean backtrack(char[][] board, int height, int width, char[] word, int n, int row, int column, int index) {
    if (
      !isValidPosition(row, column, height, width)
      || board[row][column] != word[index]
      || board[row][column] == '.'
    ) {
      return false;
    }

    if (index == n - 1) {
      return true;
    }

    char c = board[row][column];
    boolean isWordExists = false;
    board[row][column] = '.';

    for (int[] d: directions) {
      if (backtrack(board, height, width, word, n, row + d[0], column + d[1], index + 1)) {
        isWordExists = true;
        break;
      }
    }

    board[row][column] = c;
    return isWordExists;
  }

  public boolean exist(char[][] board, String word) {
    int height = board.length;
    int width = board[0].length;
    char[] characters = word.toCharArray();

    for (int i  = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (backtrack(board, height, width, characters, characters.length, i, j, 0)) {
          return true;
        }
      }
    }

    return false;
  }
}
