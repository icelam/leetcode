class Solution {
  public int deleteGreatestValue(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

    for (int[] row: grid) {
      Arrays.sort(row);
    }

    int result = 0;

    for (int i = 0; i < width; i++) {
      int columnMax = grid[0][i];

      for (int j = 1; j < height; j++) {
        columnMax = Math.max(columnMax, grid[j][i]);
      }

      result += columnMax;
    }

    return result;
  }
}
