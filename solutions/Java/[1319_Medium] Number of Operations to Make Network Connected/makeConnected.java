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
  public int makeConnected(int n, int[][] connections) {
    if (connections.length < n - 1) {
      return -1;
    }

    UnionFind uf = new UnionFind(n);
    int connectedComponents = n;

    for (int[] connection: connections) {
      if (uf.find(connection[0]) != uf.find(connection[1])) {
        connectedComponents--;
        uf.union(connection[0], connection[1]);
      }
    }

    return connectedComponents - 1;
  }
}
