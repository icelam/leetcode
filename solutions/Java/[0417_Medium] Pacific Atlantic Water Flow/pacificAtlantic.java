class Solution {
  private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  private void rainFlow(int[][] heights, int row, int column, int height, int width, boolean[][] canReachOcean) {
    if (canReachOcean[row][column]) {
      return;
    }

    canReachOcean[row][column] = true;

    for (int[] d : directions) {
      int newRow = row + d[0];
      int newColumn = column + d[1];

      if (
        isValidPosition(newRow, newColumn, height, width)
        && heights[newRow][newColumn] >= heights[row][column]
      ) {
        rainFlow(heights, newRow, newColumn, height, width, canReachOcean);
      }
    }
  }

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int height = heights.length;
    int width = heights[0].length;

    boolean[][] canReachPacific = new boolean[height][width];
    boolean[][] canReachAtlantic = new boolean[height][width];

    // Left and right boundary
    for (int i = 0; i < height; i++) {
      rainFlow(heights, i, 0, height, width, canReachPacific);
      rainFlow(heights, i, width - 1, height, width, canReachAtlantic);
    }

    // Top and bottom boundary
    for (int j = 0; j < width; j++) {
      rainFlow(heights, 0, j, height, width, canReachPacific);
      rainFlow(heights, height - 1, j, height, width, canReachAtlantic);
    }

    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
          List<Integer> position = new ArrayList<Integer>();
          position.add(i);
          position.add(j);
          result.add(position);
        }
      }
    }

    return result;
  }
}
