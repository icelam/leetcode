class Solution {
  public int largestSubmatrix(int[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;
    int result = 0;

    for (int row = 1; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (matrix[row][column] == 1) {
          matrix[row][column] += matrix[row - 1][column];
        }
      }
    }

    for (int row = 0; row < height; row++) {
      Arrays.sort(matrix[row]);

      for (int column = width - 1; column >= 0; column--) {
        result = Math.max(result, matrix[row][column] * (width - column));
      }
    }

    return result;
  }
}
