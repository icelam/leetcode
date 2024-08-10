class UnionFind {
  private int[] group;
  private int[] rank;
  private int groupCount;

  public UnionFind(int size) {
    group = new int[size];
    rank = new int[size];
    groupCount = size;

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

    groupCount--;
    return true;
  }

  public int getGroupCount() {
    return this.groupCount;
  }
}

class Solution {
  public int regionsBySlashes(String[] grid) {
    int n = grid.length;

    /**
     * Each grid can be consider as 4 subgrid, where 0 = ▽ 1 = ◁, 2 = △, 3 = ▷
     * ┌─────────┐
     * │\   0   /│
     * │ \     / │
     * │  \   /  │
     * │ 3 ∖ / 1 │
     * │   / \   │
     * │  /   \  │
     * │ /     \ │
     * │/   2   \│
     * └─────────┘
     */
    UnionFind uf = new UnionFind(4 * n * n);

    for (int row = 0; row < n; row++) {
      char[] divider = grid[row].toCharArray();

      for (int column = 0; column < n; column++) {
        int index = 4 * (row * n + column);
        char currentDivider = divider[column];

        if (currentDivider == '/') {
          // Merge 0 and 3, 1 and 2
          uf.union(index, index + 3);
          uf.union(index + 1, index + 2);
        } else if (currentDivider == '\\') {
          // Merge 0 and 1, 2 and 3
          uf.union(index, index + 1);
          uf.union(index + 2, index + 3);
        } else {
          // Merge all together
          uf.union(index, index + 1);
          uf.union(index + 1, index + 2);
          uf.union(index + 2, index + 3);
        }

        // Merge grid with the one on right and bottom
        // - subgrid 1 of current gird will be merge with subgrid 3 on the right of current grid
        // - subgrid 2 of current gird will be merge with subgrid 0 under the current grid
        if (column + 1 < n) {
          uf.union(index + 1, 4 * (row * n + column + 1) + 3);
        }

        if (row + 1 < n) {
          uf.union(index + 2, 4 * ((row + 1) * n + column));
        }
      }
    }

    return uf.getGroupCount();
  }
}
