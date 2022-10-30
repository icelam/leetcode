class Solution {
  private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public int dfs(int[][] grid, int m, int n, int k, boolean[][] visited, int row, int column, Integer[][][] dp) {
    if (row < 0 || row >= m || column < 0 || column >= n) {
      return Integer.MAX_VALUE;
    }

    // Any visited position reappearing is consider to be reached by a longer path
    if (visited[row][column]) {
      return Integer.MAX_VALUE;
    }

    if (row == 0 && column == 0) {
      return 0;
    }

    if (dp[row][column][k] != null && dp[row][column][k] != Integer.MAX_VALUE) {
      return dp[row][column][k];
    }

    if (k >= row + column) {
      dp[row][column][k] = row + column;
      return dp[row][column][k];
    }

    if (grid[row][column] == 1) {
      if (k > 0) {
        k--;
      } else {
        return Integer.MAX_VALUE;
      }
    }

    visited[row][column] = true;

    int min = Integer.MAX_VALUE;

    for (int[] d: directions) {
       min = Math.min(min, dfs(grid, m, n, k, visited, row + d[0], column  + d[1], dp));
    }

    visited[row][column] = false;

    dp[row][column][k] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
    return dp[row][column][k];
  }

  public int shortestPath(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;

    Integer[][][] dp = new Integer[m][n][k + 1];

    boolean[][] visited = new boolean[m][n];
    int result = dfs(grid, m, n, k, visited, m - 1, n - 1, dp);
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}

