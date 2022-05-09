class Solution {
  public void findMinimum(int[] memo, List<List<Integer>> triangle, int row) {
    if (row < 0) {
      return;
    }

    for (int column = 0; column <= row; column++) {
      memo[column] = triangle.get(row).get(column) + Math.min(memo[column], memo[column + 1]);
    }

    findMinimum(memo, triangle, row - 1);
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] memo = new int[n + 1];
    findMinimum(memo, triangle, n - 1);
    return memo[0];
  }
}
