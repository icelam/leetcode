class Solution {
  public void rotateClockwise(int[][] matrix) {
    for (int i = 0, j = matrix.length - 1; i < j; i++, j--) {
      int[] temp = matrix[i];
      matrix[i] = matrix[j];
      matrix[j] = temp;
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = i + 1; j < matrix.length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }

  public boolean findRotation(int[][] mat, int[][] target) {
    for (int i = 0; i < 4; i++) {
      if (Arrays.deepEquals(mat, target)) {
        return true;
      }

      rotateClockwise(mat);
    }

    return false;
  }
}
