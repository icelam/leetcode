class Solution {
  private boolean isValidPosition(int y, int x, int height, int width) {
    return y >= 0 && y < height && x >= 0 && x < width;
  }

  public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
    int gridCount = rows * cols;
    int visitedCount = 0;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] result = new int[gridCount][2];

    int distance = 1;
    int currentRow = rStart;
    int currentColumn = cStart;
    int currentDirection = 0;

    while (visitedCount < gridCount) {
      for (int i = 0; i < distance; i++) {
        if (isValidPosition(currentRow, currentColumn, rows, cols)) {
          result[visitedCount][0] = currentRow;
          result[visitedCount][1] = currentColumn;
          visitedCount++;
        }

        currentRow += directions[currentDirection][0];
        currentColumn += directions[currentDirection][1];
      }

      if (currentDirection % 2 == 1) {
        distance++;
      }

      currentDirection = (currentDirection + 1) % 4;
    }

    return result;
  }
}
