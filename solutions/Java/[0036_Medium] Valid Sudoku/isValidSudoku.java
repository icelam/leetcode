class Solution {
  private static int[][] leftTopPositions = new int[][]{
    {0, 0}, {0, 3}, {0, 6},
    {3, 0}, {3, 3}, {3, 6},
    {6, 0}, {6, 3}, {6, 6}
  };

  private boolean isAllCountLessThanOne(int[] counts) {
    for (int c: counts) {
      if (c > 1) {
        return false;
      }
    }

    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    int[] horizontalCounts = new int[10];
    int[] verticalCounts = new int[10];
    int[] areaCounts = new int[10];

    // Scan horizontially and vertically
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char c1 = board[i][j];
        char c2 = board[j][i];

        if (Character.isDigit(c1)) {
          horizontalCounts[c1 - '0']++;
        }

        if (Character.isDigit(c2)) {
          verticalCounts[c2 - '0']++;
        }
      }

      if (
        !isAllCountLessThanOne(horizontalCounts)
        || !isAllCountLessThanOne(verticalCounts)
      ) {
        return false;
      }

      Arrays.fill(horizontalCounts, 0);
      Arrays.fill(verticalCounts, 0);
    }

    // Scan 3*3 area
    for (int[] position: leftTopPositions) {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          char c = board[position[0] + i][position[1] + j];

          if (Character.isDigit(c)) {
            areaCounts[c - '0']++;
          }
        }
      }

      if (!isAllCountLessThanOne(areaCounts)) {
        return false;
      }

      Arrays.fill(areaCounts, 0);
    }

    return true;
  }
}
