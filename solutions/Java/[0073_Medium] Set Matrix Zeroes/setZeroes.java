class Solution {
  public void setZeroes(int[][] matrix) {
    int rowSize = matrix.length;
    int columnSize = matrix[0].length;
    HashSet<Integer> rowsToReset = new HashSet<Integer>();
    HashSet<Integer> columnsToReset = new HashSet<Integer>();

    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < columnSize; j++) {
        if (matrix[i][j] == 0) {
          rowsToReset.add(i);
          columnsToReset.add(j);
        }
      }
    }

    for (int row: rowsToReset) {
      for (int column = 0; column < columnSize; column++) {
        matrix[row][column] = 0;
      }
    }

    for (int column: columnsToReset) {
      for (int row = 0; row < rowSize; row++) {
        matrix[row][column] = 0;
      }
    }
  }
}
