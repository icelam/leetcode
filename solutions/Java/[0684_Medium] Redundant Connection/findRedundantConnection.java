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
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    UnionFind uf = new UnionFind(n + 1);

    for (int[] edge: edges) {
      if (uf.find(edge[0]) == uf.find(edge[1])) {
        return edge;
      }

      uf.union(edge[0], edge[1]);
    }

    return new int[0];
  }
}
