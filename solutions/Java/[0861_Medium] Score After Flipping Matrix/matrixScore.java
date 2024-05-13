class Solution {
  public static int convertToDecimal(int[] binaryArray) {
    int result = 0;

    for (int bit: binaryArray) {
      result = (result << 1) | bit;
    }

    return result;
  }

  public int matrixScore(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int result = 0;

    for (int row = 0; row < height; row++) {
      if (grid[row][0] == 0) {
        for (int column = 0; column < width; column++) {
          grid[row][column] = 1 - grid[row][column];
        }
      }
    }

    for (int column = 1; column < width; column++) {
      int bitCount = 0;

      for (int row = 0; row < height; row++) {
        bitCount += grid[row][column];
      }

      int zeroCount = height - bitCount;

      if (zeroCount > bitCount) {
        for (int row = 0; row < height; row++) {
          grid[row][column] = 1 - grid[row][column];
        }
      }
    }

    for (int[] row: grid) {
      result += convertToDecimal(row);
    }

    return result;
  }
}
