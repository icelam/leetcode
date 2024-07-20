class Solution {
  public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
    int m = rowSum.length;
    int n = colSum.length;
    int[][] matrix = new int[m][n];

    for (int row = 0; row < m; row++) {
      for (int column = 0; column < n; column++) {
        matrix[row][column] = Math.min(rowSum[row], colSum[column]);
        rowSum[row] -= matrix[row][column];
        colSum[column] -= matrix[row][column];
      }
    }

    return matrix;
  }
}
