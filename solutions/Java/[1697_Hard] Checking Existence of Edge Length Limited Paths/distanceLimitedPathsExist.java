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
  public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
    int m = queries.length;
    boolean[] result = new boolean[m];
    int[][] sortedQueryIndices = new int[m][2];
    UnionFind uf = new UnionFind(n);

    for (int i = 0; i < m; i++) {
      sortedQueryIndices[i][0] = i;
      sortedQueryIndices[i][1] = queries[i][2];
    }

    Arrays.sort(sortedQueryIndices, (a, b) -> a[1] - b[1]);
    Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

    int queryIndices = 0;

    for (int i = 0; i < edgeList.length; i++) {
      while (queryIndices < m && queries[sortedQueryIndices[queryIndices][0]][2] <= edgeList[i][2]) {
        boolean isPathExists = uf.find(queries[sortedQueryIndices[queryIndices][0]][0]) == uf.find(queries[sortedQueryIndices[queryIndices][0]][1]);
        result[sortedQueryIndices[queryIndices][0]] = isPathExists;
        queryIndices++;
      }

      if (queryIndices >= m) {
        return result;
      }

      uf.union(edgeList[i][0], edgeList[i][1]);
    }

    while (queryIndices < m) {
      boolean isPathExists = uf.find(queries[sortedQueryIndices[queryIndices][0]][0]) == uf.find(queries[sortedQueryIndices[queryIndices][0]][1]);
      result[sortedQueryIndices[queryIndices][0]] = isPathExists;
      queryIndices++;
    }

    return result;
  }
}
