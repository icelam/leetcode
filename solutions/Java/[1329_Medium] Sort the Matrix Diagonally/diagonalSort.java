class Solution {
  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row <= height - 1 && column >= 0 && column <= width - 1;
  }

  public int[][] diagonalSort(int[][] mat) {
    int height = mat.length;
    int width = mat[0].length;

    int startRow = mat.length - 1;
    int startColumn = 0;
    int currentRow = startRow;
    int currentColumn = startColumn;

    while (currentColumn < width) {
      int[] values = new int[height];
      int i = 0;

      while (isValidPosition(currentRow, currentColumn, height, width)) {
        values[i] = mat[currentRow][currentColumn];
        currentRow++;
        currentColumn++;
        i++;
      }

      Arrays.sort(values);

      currentRow = startRow;
      currentColumn = startColumn;

      for (int j = 0; j < height; j++) {
        if (values[j] == 0) {
          continue;
        }

        mat[currentRow][currentColumn] = values[j];
        currentRow++;
        currentColumn++;
      }

      if (startRow != 0) {
        startRow--;
      } else {
        startColumn++;
      }

      currentRow = startRow;
      currentColumn = startColumn;
    }

    return mat;
  }
}
