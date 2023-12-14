class Solution {
  public int[][] onesMinusZeros(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

    int[] onesRow = new int[height];
    int[] onesCol = new int[width];

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        onesRow[row] += grid[row][column];
        onesCol[column] += grid[row][column];
      }
    }

    int[][] diff = new int[height][width];

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        diff[row][column] = onesRow[row] + onesCol[column] - (height - onesRow[row]) - (width - onesCol[column]);
      }
    }

    return diff;
  }
}
