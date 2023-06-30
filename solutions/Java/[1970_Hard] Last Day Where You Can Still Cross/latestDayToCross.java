class UnionFind {
  private int[] group;
  private int[] rank;

  public UnionFind(int size) {
    group = new int[size];
    rank = new int[size];

    for (int i = 0; i < size; i++) {
      group[i] = i;
    }
  }

  public int find(int vertex) {
    if (group[vertex] != vertex) {
      group[vertex] = find(group[vertex]);
    }
    return group[vertex];
  }

  public boolean union(int vertex1, int vertex2) {
    int group1 = find(vertex1);
    int group2 = find(vertex2);

    if (group1 == group2) {
      return false;
    }

    if (rank[group1] > rank[group2]) {
      group[group2] = group1;
    } else if (rank[group1] < rank[group2]) {
      group[group1] = group2;
    } else {
      group[group1] = group2;
      rank[group2] += 1;
    }

    return true;
  }
}

class Solution {
  private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private boolean isValidPosition(int y, int x, int height, int width) {
    return y >= 0 && y < height && x >= 0 && x < width;
  }

  private boolean isTop(int y) {
    return y == 0;
  }

  private boolean isBottom(int y, int height) {
    return y == height - 1;
  }

  private int convertCordinateToIndex(int y, int x, int width) {
    return y * width + x + 1;
  }

  public int latestDayToCross(int row, int col, int[][] cells) {
    int n = cells.length;
    int[][] state = new int[row][col];
    UnionFind uf = new UnionFind(row * col + 2);

    for (int i = n - 1; i >= 0; i--) {
      int y = cells[i][0] - 1;
      int x = cells[i][1] - 1;
      state[y][x] = 1;

      int currentIndex = convertCordinateToIndex(y, x, col);

      for (int[] d : directions) {
        int newY = y + d[0];
        int newX = x + d[1];

        if (isValidPosition(newY, newX, row, col) && state[newY][newX] == 1) {
          int newIndex = convertCordinateToIndex(newY, newX, col);
          uf.union(currentIndex, newIndex);
        }
      }

      int lastIndex = row * col + 1;

      if (isTop(y)) {
        uf.union(0, currentIndex);
      }

      if (isBottom(y, row)) {
        uf.union(currentIndex, lastIndex);
      }

      if (uf.find(0) == uf.find(lastIndex)) {
        return i;
      }
    }

    return -1;
  }
}
