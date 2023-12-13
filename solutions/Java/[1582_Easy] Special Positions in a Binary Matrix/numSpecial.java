class Solution {
  public int numSpecial(int[][] mat) {
    int height = mat.length;
    int width = mat[0].length;

    int[] rowSum = new int[height];
    int[] columnSum = new int[width];

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        rowSum[row] += mat[row][column];
        columnSum[column] += mat[row][column];
      }
    }

    int result = 0;

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (mat[row][column] == 1 && rowSum[row] == 1 && columnSum[column] == 1) {
          result++;
        }
      }
    }

    return result;
  }
}
