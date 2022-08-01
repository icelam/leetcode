class Solution {
  public int uniquePaths(int m, int n) {
    int rowStart = 0;
    int columnStart = 0;

    int[][] memo = new int[m][n];

    while (rowStart < m && columnStart < n) {
      // Towards right - scan row
      for (int x = columnStart; x < n; x++) {
        if (columnStart == 0) {
          memo[rowStart][x] = 1;
        } else {
          memo[rowStart][x] = (rowStart - 1 >= 0 ? memo[rowStart - 1][x] : 0) + (x - 1 >= 0 ? memo[rowStart][x - 1] : 0);
        }
      }
      rowStart++;

      // Towards down - scan column
      for (int y = rowStart; y < m; y++) {
        memo[y][columnStart] = (y - 1 >= 0 ? memo[y - 1][columnStart] : 0) + (columnStart - 1 >= 0 ? memo[y][columnStart - 1] : 0);
      }
      columnStart++;
    }

    return memo[m - 1][n - 1];
  }
}
