class Solution {
  private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int row, int column, int size) {
    return row >= 0 && row < size && column >= 0 && column < size;
  }

  public int maximumSafenessFactor(List<List<Integer>> grid) {
    int n = grid.size();

    // Base case: First or last cell has theif
    if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
      return 0;
    }

    int[][] distanceToThief = new int[n][n];
    int[][] safetyFactor = new int[n][n];
    Queue<int[]> queue = new LinkedList<>();

    // Calculate saftey factor
    for (int row = 0; row < n; row++) {
      for (int column = 0; column < n; column++) {
        if (grid.get(row).get(column) == 1) {
          distanceToThief[row][column] = 1;
          queue.add(new int[]{row, column});
        }
      }
    }

    while (!queue.isEmpty()) {
      int batchSize = queue.size();

      for (int i = 0; i < batchSize; i++) {
        int[] currentThief = queue.remove();

        for (int[] d: directions) {
          int newRow = currentThief[0] + d[0];
          int newColumn = currentThief[1] + d[1];

          if (isValidPosition(newRow, newColumn, n) && distanceToThief[newRow][newColumn] == 0) {
            queue.add(new int[]{newRow, newColumn});
            distanceToThief[newRow][newColumn] = distanceToThief[currentThief[0]][currentThief[1]] + 1;
          }
        }
      }
    }

    // Start from last cell, calculate the min factor of each path
    queue.offer(new int[]{n - 1, n - 1});
    safetyFactor[n - 1][n - 1] = distanceToThief[n - 1][n - 1];

    while (!queue.isEmpty()) {
      int[] currentLocation = queue.remove();

      for (int[] d: directions) {
        int newRow = currentLocation[0] + d[0];
        int newColumn = currentLocation[1] + d[1];

        if (isValidPosition(newRow, newColumn, n)) {
          int newSafetyFactor = Math.min(distanceToThief[newRow][newColumn], safetyFactor[currentLocation[0]][currentLocation[1]]);

          if (newSafetyFactor > safetyFactor[newRow][newColumn]) {
            safetyFactor[newRow][newColumn] = newSafetyFactor;
            queue.add(new int[]{newRow, newColumn});
          }
        }
      }
    }

    return safetyFactor[0][0] - 1;
  }
}
