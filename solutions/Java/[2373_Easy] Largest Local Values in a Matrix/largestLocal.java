class Solution {
  public int[][] largestLocal(int[][] grid) {
    int n = grid.length;
    int m = n - 2;
    int[][] result = new int[m][m];

    for (int row = 0; row < m; row++) {
      for (int column = 0; column < m; column++) {
        for (int subRow = row; subRow  < row + 3; subRow++) {
          for (int subColumn = column; subColumn  < column + 3; subColumn++) {
            if (result[row][column] < grid[subRow][subColumn]) {
              result[row][column] = grid[subRow][subColumn];
            }
          }
        }
      }
    }

    return result;
  }
}
