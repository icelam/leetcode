class Solution {
  public int[] findMissingAndRepeatedValues(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int n = height * width;
    boolean[] isSeen = new boolean[n + 1];
    int[] result = new int[2];

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        int value = grid[row][column];

        if (isSeen[value]) {
          result[0] = value;
        }

        isSeen[value] = true;
      }
    }

    for (int i = 1; i < n + 1; i++) {
      if (!isSeen[i]) {
        result[1] = i;
        break;
      }
    }

    return result;
  }
}
