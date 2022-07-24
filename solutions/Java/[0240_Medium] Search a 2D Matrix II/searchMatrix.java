class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int rowSize = matrix.length;
    int columnSize = matrix[0].length;

    int row = rowSize - 1;
    int column = 0;

    while (row >= 0 && column < columnSize) {
      if (matrix[row][column] == target) {
        return true;
      } else if (matrix[row][column] < target) {
        column++;
      } else {
        row--;
      }
    }

    return false;
  }
}
