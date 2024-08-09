class Solution {
  private static boolean isMagicSquare(int[][] grid, int row, int col) {
    int sumRow0 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
    int sumRow1 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
    int sumRow2 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];

    int sumCol0 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
    int sumCol1 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
    int sumCol2 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];

    int sumDiagonal1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
    int sumDiagonal2 = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];

    int[] frequencies = new int[16];

    for (int currentRow = row; currentRow < row + 3; currentRow++) {
      for (int currentCol = col; currentCol < col + 3; currentCol++) {
        frequencies[grid[currentRow][currentCol]]++;
      }
    }

    int uniqueNumberCount = 0;

    for (int i = 1; i <= 9; i++) {
      if (frequencies[i] == 1) {
        uniqueNumberCount++;
      }
    }

    return (
      uniqueNumberCount == 9
      && sumRow0 == sumRow1
      && sumRow1 == sumRow2
      && sumRow2 == sumCol0
      && sumCol1 == sumCol2
      && sumCol2 == sumDiagonal1
      && sumDiagonal1 == sumDiagonal2
    );
  }

  public int numMagicSquaresInside(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int magicSquareCount = 0;

    if (height < 3 || width < 3) {
      return 0;
    }

    for (int row = 0; row < height - 2; row++) {
      for (int col = 0; col < width - 2; col++) {
        if (isMagicSquare(grid, row, col)) {
          magicSquareCount += 1;
        }
      }
    }

    return magicSquareCount;
  }
}
