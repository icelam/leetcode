class Solution {

  public int[][] modifiedMatrix(int[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;
    int[] maxValueInColumn = new int[width];
    Arrays.fill(maxValueInColumn, -1);

    for (int column = 0; column < width; column++) {
      for (int row = 0; row < height; row++) {
        maxValueInColumn[column] = Math.max(maxValueInColumn[column], matrix[row][column]);
      }
    }

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (matrix[row][column] == -1) {
          matrix[row][column] = maxValueInColumn[column];
        }
      }
    }

    return matrix;
  }
}
