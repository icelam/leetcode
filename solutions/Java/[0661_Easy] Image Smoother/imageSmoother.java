class Solution {
  private int[][] directions = new int[][]{
    {-1, 0},
    {-1, 1},
    {0, 1},
    {1, 1},
    {1, 0},
    {1, -1},
    {0, -1},
    {-1, -1},
    {0, 0}
  };

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public int[][] imageSmoother(int[][] img) {
    int height = img.length;
    int width = img[0].length;
    int[][] result = new int[height][width];

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        int total = 0;
        int count = 0;

        for (int[] d: directions) {
          int newRow = row - d[0];
          int newColumn = column - d[1];

          if (isValidPosition(newRow, newColumn, height, width)) {
            count++;
            total += img[newRow][newColumn];
          }
        }

        result[row][column] = total / count;
      }
    }

    return result;
  }
}
