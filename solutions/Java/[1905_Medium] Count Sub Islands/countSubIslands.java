class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  public int countSubIslands(int[][] grid1, int[][] grid2) {
    int height = grid1.length;
    int width = grid1[0].length;
    int result = 0;

    for (int row = 0; row < height; ++row) {
      for (int column = 0; column < width; ++column) {
        if (grid2[row][column] == 1) {
          Queue<int[]> queue = new LinkedList<>();
          queue.add(new int[]{row, column});

          grid2[row][column] = 0;

          boolean isSubIsland = grid1[row][column] == 1;

          while (!queue.isEmpty()) {
            int[] currentPosition = queue.remove();

            for (int[] d: directions) {
              int newRow = currentPosition[0] + d[0];
              int newColumn = currentPosition[1] + d[1];

              if (isValidPosition(newRow, newColumn, height, width) && grid2[newRow][newColumn] == 1) {
                queue.add(new int[]{newRow, newColumn});
                grid2[newRow][newColumn] = 0;

                if (grid1[newRow][newColumn] != 1) {
                  isSubIsland = false;
                }
              }
            }
          }

          if (isSubIsland) {
            result++;
          }
        }
      }
    }

    return result;
  }
}
