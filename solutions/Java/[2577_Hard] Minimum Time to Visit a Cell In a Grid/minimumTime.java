import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
  private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public int minimumTime(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;

    if (grid[0][1] > 1 && grid[1][0] > 1) {
      return -1;
    }

    int[][] minTime = new int[height][width];
    for (int i = 0; i < height; i++) {
      Arrays.fill(minTime[i], Integer.MAX_VALUE);
    }

    minTime[0][0] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.add(new int[] {0, 0, 0});

    while (!pq.isEmpty()) {
      int[] currentInfo = pq.poll();
      int currentTime = currentInfo[0];
      int row = currentInfo[1];
      int column = currentInfo[2];

      if (currentTime > minTime[row][column]) {
        continue;
      }

      if (row == height - 1 && column == width - 1) {
        return currentTime;
      }

      for (int[] d : directions) {
        int newRow = row + d[0];
        int newColumn = column + d[1];

        if (isValidPosition(newRow, newColumn, height, width)) {
          int newTime = Math.max(currentTime + 1, grid[newRow][newColumn]);
          newTime += (newTime - newRow - newColumn) % 2;

          if (newTime < minTime[newRow][newColumn]) {
            minTime[newRow][newColumn] = newTime;
            pq.add(new int[] {newTime, newRow, newColumn});
          }
        }
      }
    }

    return -1;
  }
}
