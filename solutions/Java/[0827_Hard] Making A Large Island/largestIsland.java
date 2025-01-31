class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int row, int column, int size) {
    return row >= 0 && row < size && column >= 0 && column < size;
  }

  public int dfs(int[][] grid, int row, int column, int[][] group, int groupId) {
    int n = grid.length;
    int result = 1;
    group[row][column] = groupId;

    for (int[] d: directions) {
      int newRow = row + d[0];
      int newColumn = column + d[1];

      if (isValidPosition(newRow, newColumn, n) && grid[newRow][newColumn] == 1 && group[newRow][newColumn] == 0) {
        result += dfs(grid, newRow, newColumn, group, groupId);
      }
    }

    return result;
  }

  public int largestIsland(int[][] grid) {
    int n = grid.length;
    int result = 0;
    int[][] group = new int[n][n];
    Map<Integer, Integer> islandSize = new HashMap<>();

    // Mark island group using DFS
    for (int row = 0; row < n; row++) {
      for (int column = 0; column < n; column++) {
        if (grid[row][column] == 1 && group[row][column] == 0) {
          int groupId = row * n + column + 1;
          islandSize.put(groupId, dfs(grid, row, column, group, groupId));
          result = Math.max(result, islandSize.get(groupId));
        }
      }
    }

    // Convert each possible water grid to land grid and calculate island size if the conversion connects two islands together
    for (int row = 0; row < n; row++) {
      for (int column = 0; column < n; column++) {
        if (grid[row][column] == 0) {
          int connectedSize = 1;
          Set<Integer> connectedGroup = new HashSet<>();

          for (int[] d: directions) {
            int newRow = row + d[0];
            int newColumn = column + d[1];

            // Skip if change does not connect to new island on certain direction, or connects to a connected island
            if (!isValidPosition(newRow, newColumn, n) || grid[newRow][newColumn] == 0 || connectedGroup.contains(group[newRow][newColumn])) {
              continue;
            }

            connectedSize += islandSize.get(group[newRow][newColumn]);
            connectedGroup.add(group[newRow][newColumn]);
          }

          result = Math.max(result, connectedSize);
        }
      }
    }

    return result;
  }
}
