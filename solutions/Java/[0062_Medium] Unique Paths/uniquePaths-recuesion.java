
class Solution {
  private int[][] memo;

  public int traverse(int row, int column, int height, int width) {
    if (row == 0 && column == 0) {
      return 1;
    }

    if (row < 0 || column < 0) {
      return 0;
    }

    if (memo[row][column] > 0) {
      return memo[row][column];
    }

    memo[row][column] = traverse(row - 1, column, height, width) + traverse(row, column - 1, height, width);

    return memo[row][column];
  }

  public int uniquePaths(int m, int n) {
    memo = new int[m][n];
    return traverse(m - 1, n - 1, m, n);
  }
}
