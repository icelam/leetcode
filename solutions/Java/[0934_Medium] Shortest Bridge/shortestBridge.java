class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int y, int x, int height, int width) {
    return y >= 0 && y < height && x >= 0 && x < width;
  }

  private boolean isConnectedWithIsland(int[][] grid, int y, int x, int height, int width, int targetIsland) {
    boolean isConnected = false;
    for (int[] d: directions) {
      int newY = y + d[0];
      int newX = x + d[1];

      if (isValidPosition(newY, newX, height, width) && grid[newY][newX] == targetIsland) {
        isConnected = true;
        break;
      }
    }
    return isConnected;
  }

  private void queueIslandBoundary(int[][] grid, int y, int x, int height, int width, Queue<int[]> queue) {
    if (!isValidPosition(y, x, height, width) || grid[y][x] == 2) {
      return;
    }

    if (grid[y][x] == 0) {
      queue.add(new int[]{y, x});
      return;
    }

    grid[y][x] = 2;

    for (int[] d: directions) {
      queueIslandBoundary(grid, y + d[0], x + d[1], height, width, queue);
    }
  }

  public int shortestBridge(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();

    // Identify Island 2 and queue boundary
    boolean isSecondIslandLocated = false;
    for (int y = 0; y < height && !isSecondIslandLocated; y++) {
      for (int x = 0; x < width && !isSecondIslandLocated; x++) {
        if (grid[y][x] == 1) {
          queueIslandBoundary(grid, y, x, height, width, queue);
          isSecondIslandLocated = true;
        }
      }
    }

    int bridgeLength = 0;
    boolean isBridgeConnected = false;

    while (!queue.isEmpty() && !isBridgeConnected) {
      int batchSize = queue.size();
      bridgeLength++;

      for (int i = 0; i < batchSize; i++) {
        int[] currentTile = queue.remove();
        if (isConnectedWithIsland(grid, currentTile[0], currentTile[1], height, width, 1)) {
          isBridgeConnected = true;
          break;
        }

        for (int[] d: directions) {
          int newY = currentTile[0] + d[0];
          int newX = currentTile[1] + d[1];

          if (isValidPosition(newY, newX, height, width) && grid[newY][newX] == 0) {
            queue.add(new int[]{newY, newX});
            grid[newY][newX] = -1;
          }
        }
      }
    }

    return bridgeLength;
  }
}
