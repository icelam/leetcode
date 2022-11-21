class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public boolean isWall(char[][] maze, int row, int column) {
    return maze[row][column] == '+';
  }

  public boolean isEntrance(int row, int column, int[] entrance) {
    return row == entrance[0] && column == entrance[1];
  }

  public boolean isExit(int row, int column, int height, int width) {
    return row == 0 || column == 0 || row == height - 1 || column == width - 1;
  }

  public int nearestExit(char[][] maze, int[] entrance) {
    int height = maze.length;
    int width = maze[0].length;

    Queue<int[]> validPositions = new LinkedList<>();
    validPositions.add(entrance);
    maze[entrance[0]][entrance[1]] = '+';

    int step = 0;

    while (!validPositions.isEmpty()) {
      int batchSize = validPositions.size();

      for (int i = 0; i < batchSize; i++) {
        int[] currentPosition = validPositions.remove();
        int currentRow = currentPosition[0];
        int currentColumn = currentPosition[1];

        for (int[] d: directions) {
          int newRow = currentRow + d[0];
          int newColumn = currentColumn + d[1];

          if (
            isValidPosition(newRow, newColumn, height, width)
            && !isWall(maze, newRow, newColumn)
          ) {
            if (
              !isEntrance(newRow, newColumn, entrance)
              && isExit(newRow, newColumn, height, width)
            ) {
              return step + 1;
            }

            maze[newRow][newColumn] = '+';
            validPositions.add(new int[] {newRow, newColumn});
          }
        }
      }

      step++;
    }

    return -1;
  }
}
