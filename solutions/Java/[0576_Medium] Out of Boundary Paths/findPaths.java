class Solution {
  private int[][][] memo;
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  private int move(int m, int n, int maxMove, int startRow, int startColumn, int movedTimes) {
    if (movedTimes > maxMove) {
      return 0;
    }

    if (!isValidPosition(startRow, startColumn, m, n)) {
      return 1;
    }

    if (memo[startRow][startColumn][movedTimes] != -1) {
      return memo[startRow][startColumn][movedTimes];
    }

    long result = 0;

    for (int[] d: directions) {
      result += move(m, n, maxMove, startRow + d[0], startColumn + d[1], movedTimes + 1);
    }

    int remainder = (int) (result % (1e9 + 7));

    memo[startRow][startColumn][movedTimes] = remainder;

    return remainder;
  }

  public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    memo = new int[m][n][maxMove + 1];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k <= maxMove; k++) {
          memo[i][j][k] = -1;
        }
      }
    }

    return move(m, n, maxMove, startRow, startColumn, 0);
  }
}
