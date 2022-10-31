class Solution {
  public boolean isToeplitzMatrix(int[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;

    for (int row = 0; row < height - 1; row++) {
      for (int column = 0; column < width - 1; column++) {
        if (matrix[row][column] != matrix[row + 1][column + 1]) {
          return false;
        }
      }
    }

    return true;
  }
}
