class Solution {
  public int[][] matrixReshape(int[][] mat, int row, int column) {
    int originalRowCount = mat.length;
    int originalColumnCount = mat[0].length;

    if (
      (originalRowCount == row && originalColumnCount == column)
      || (originalRowCount * originalColumnCount != row * column)
    ) {
      return mat;
    }

    int currentRow = 0;
    int currentColumn = 0;

    int[][] result = new int[row][column];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        result[i][j] = mat[currentRow][currentColumn];

        currentColumn++;

        if (currentColumn == originalColumnCount) {
          currentRow++;
          currentColumn = 0;
        }
      }
    }

    return result;
  }
}
