class Solution {
  public int countServers(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int[] rowCount = new int[height];
    int[] columnCount = new int[width];
    int totalCount = 0;

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (grid[row][column] == 1) {
          totalCount++;
          rowCount[row]++;
          columnCount[column]++;
        }
      }
    }

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (grid[row][column] == 1 && rowCount[row] == 1 && columnCount[column] == 1) {
          totalCount--;
        }
      }
    }

    return totalCount;
  }
}
