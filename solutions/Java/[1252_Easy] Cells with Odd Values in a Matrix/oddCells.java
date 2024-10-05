class Solution {
  public int oddCells(int m, int n, int[][] indices) {
    int[][] matrix = new int[m][n];

    for (int[] position: indices) {
      int row = position[0];
      int column = position[1];

      for (int i = 0; i < m; i++) {
        matrix[i][column]++;
      }

      for (int j = 0; j < n; j++) {
        matrix[row][j]++;
      }
    }

    int count = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] % 2 == 1) {
          count++;
        }
      }
    }

    return count;
  }
}
