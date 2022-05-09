class Solution {
  private int[][] memo;

  public int findMinimum(List<List<Integer>> triangle, int row, int column) {
    if (row == triangle.size() - 1) {
      return triangle.get(row).get(column);
    }

    if (memo[row][column] != Integer.MIN_VALUE) {
      return memo[row][column];
    }

    int value =  triangle.get(row).get(column);
    memo[row][column] = Math.min(
      value + findMinimum(triangle, row + 1, column),
      value + findMinimum(triangle, row + 1, column + 1)
    );
    return memo[row][column];
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    memo = new int[n][n];

    for (int[] row: memo) {
      Arrays.fill(row, Integer.MIN_VALUE);
    }

    return findMinimum(triangle, 0, 0);
  }
}
