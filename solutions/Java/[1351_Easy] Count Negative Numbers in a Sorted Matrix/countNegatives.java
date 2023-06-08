class Solution {
  public int countNegatives(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int result = 0;

    for (int row = 0; row < height; row++) {
      for (int column = width - 1; column >= 0; column--) {
        if (grid[row][column] >= 0) {
          break;
        }
        result++;
      }
    }

    return result;
  }
}
