class Solution {
  private static int[][] directions = new int[][]{{1, 0}, {0, 1}};

  private boolean isValidPosition(int row, int column, int height, int width) {
    return row >= 0 && row < height && column >= 0 && column < width;
  }

  private int[] dfs(int[][] grid, int row, int column, int height, int width) {
    int[] rightBottom = new int[]{-1, -1};

    if (isValidPosition(row, column, height, width) && grid[row][column] == 1) {
      grid[row][column] = -1;
      rightBottom[0] = row;
      rightBottom[1] = column;

      for (int[] d: directions) {
        int[] possobleRightBottom = dfs(grid, row + d[0], column + d[1], height, width);

        if (possobleRightBottom[0] >= rightBottom[0] && possobleRightBottom[1] >= rightBottom[1]) {
          rightBottom = possobleRightBottom;
        }
      }
    }

    return rightBottom;
  }

  public int[][] findFarmland(int[][] land) {
    int height = land.length;
    int width = land[0].length;
    List<int[]> coordinates = new ArrayList<>();

    for (int row = 0; row < height; row++) {
      for (int column = 0; column < width; column++) {
        if (land[row][column] == 1) {
          int[] rightBottom = dfs(land, row, column, height, width);
          coordinates.add(new int[]{row, column, rightBottom[0], rightBottom[1]});
        }
      }
    }

    return coordinates.toArray(new int[coordinates.size()][]);
  }
}
