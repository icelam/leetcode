class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int height = obstacleGrid.length;
    int width = obstacleGrid[0].length;
    int rowStart = 0;
    int columnStart = 0;

    int[][] memo = new int[height][width];

    while (rowStart < height && columnStart < width) {
      boolean isBlocked = false;

      // Towards right - scan row
      for (int x = columnStart; x < width; x++) {
        if (columnStart == 0) {
          if (obstacleGrid[rowStart][x] == 1) {
            isBlocked = true;
          }
          memo[rowStart][x] = isBlocked ? 0 : 1;
        } else if (obstacleGrid[rowStart][x] == 1) {
          memo[rowStart][x] = 0;
        } else {
          memo[rowStart][x] = (rowStart - 1 >= 0 ? memo[rowStart - 1][x] : 0) + (x - 1 >= 0 ? memo[rowStart][x - 1] : 0);
        }
      }
      rowStart++;

      // Towards down - scan column
      for (int y = rowStart; y < height; y++) {
        if (obstacleGrid[y][columnStart] == 1) {
          memo[y][columnStart] = 0;
        } else {
          memo[y][columnStart] = (y - 1 >= 0 ? memo[y - 1][columnStart] : 0) + (columnStart - 1 >= 0 ? memo[y][columnStart - 1] : 0);
        }
      }
      columnStart++;
    }

    return memo[height - 1][width - 1];
  }
}
