class Solution {
  private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public int minCost(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int[] visited = new int[height * width];
    int[] distance = new int[height * width];

    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[0] = 0;

    Deque<Integer> q = new ArrayDeque<>();
    q.addLast(0);

    while (!q.isEmpty()) {
      int currentPosition = q.removeFirst();

      if (visited[currentPosition] == 1) {
        continue;
      }

      visited[currentPosition] = 1;
      int row = currentPosition / width;
      int column = currentPosition % width;

      for (int i = 0; i < directions.length; i++) {
        int newRow = row + directions[i][0];
        int newColumn = column + directions[i][1];
        int newPosition = newRow * width + newColumn;
        int newDistance = distance[currentPosition] + (grid[row][column] != (i + 1) ? 1 : 0);

        if (isValidPosition(newRow, newColumn, height, width) && newDistance < distance[newPosition]) {
          distance[newPosition] = newDistance;

          if (grid[row][column] == i + 1) {
            q.addFirst(newPosition);
          } else {
            q.addLast(newPosition);
          }
        }
      }
    }

    return distance[height * width - 1];
  }
}
