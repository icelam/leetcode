class Solution {
  public int[][] construct2DArray(int[] original, int m, int n) {
    int length = original.length;

    if (m * n != length) {
      return new int[0][0];
    }

    int[][] result = new int[m][n];
    int pointer = 0;

    for (int row = 0; row < m; row++) {
      for (int column = 0; column < n; column++) {
        result[row][column] = original[pointer];
        pointer++;
      }
    }

    return result;
  }
}
