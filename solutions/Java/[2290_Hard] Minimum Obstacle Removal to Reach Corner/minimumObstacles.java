class Solution {
  private static int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public int minimumObstacles(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int[][] distance = new int[height][width];

    for (int[] row: distance) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }

    distance[0][0] = 0;

    Deque<int[]> dequeue = new ArrayDeque<>();
    dequeue.addFirst(new int[] {0, 0});

    while (!dequeue.isEmpty()) {
      int[] position = dequeue.removeFirst();
      int row = position[0];
      int column = position[1];

      for (int[] d: directions) {
        int newRow = row + d[0];
        int newColumn = column + d[1];

        if (isValidPosition(newRow, newColumn, height, widht)) {
          int hasObstacle = grid[newRow][newColumn];

          if (distance[row][column] + hasObstacle < distance[newRow][newColumn]) {
            distance[newRow][newColumn] = distance[row][column] + hasObstacle;

            if (hasObstacle == 0) {
              dequeue.addFirst(new int[] {newRow, newColumn});
            } else {
              dequeue.addLast(new int[] {newRow, newColumn});
            }
          }
        }
      }
    }

    return distance[height - 1][width - 1];
  }
}
