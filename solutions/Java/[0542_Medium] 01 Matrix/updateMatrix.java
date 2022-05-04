class Solution {
  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row <= height - 1 && column >= 0 && column <= width - 1;
  }

  public int[][] updateMatrix(int[][] mat) {
    int[][] result = new int[mat.length][mat[0].length];

    Queue<int[]> queue = new LinkedList<>();

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 0) {
          result[i][j] = 0;
          queue.add(new int[]{i, j});
        } else {
          result[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while (!queue.isEmpty()) {
      int[] position = queue.remove();
      int currentRow = position[0];
      int currentColumn = position[1];
      int newDistance = result[currentRow][currentColumn] + 1;

      for (int[] d: directions) {
        int newRow = currentRow + d[0];
        int newColumn = currentColumn + d[1];

        if (
          isValidPosition(newRow, newColumn, mat.length, mat[0].length)
          && result[newRow][newColumn] > newDistance
        ) {
          result[newRow][newColumn] = newDistance;
          queue.add(new int[]{newRow, newColumn});
        }
      }
    }

    return result;
  }
}
