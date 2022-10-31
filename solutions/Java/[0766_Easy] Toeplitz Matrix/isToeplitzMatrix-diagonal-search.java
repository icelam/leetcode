class Solution {
  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public boolean isToeplitzMatrix(int[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;

    int startRow = matrix.length - 1;
    int startColumn = 0;

    while (startColumn < width) {
      int currentRow = startRow + 1;
      int currentColumn = startColumn + 1;
      int targetValue = matrix[startRow][startColumn];

      while (isValidPosition(currentRow, currentColumn, height, width)) {
        if (matrix[currentRow][currentColumn] != targetValue) {
          return false;
        }

        currentRow++;
        currentColumn++;
      }

      if (startRow != 0) {
        startRow--;
      } else {
        startColumn++;
      }
    }

    return true;
  }
}
