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
  public boolean equationsPossible(String[] equations) {
    UnionFind uf = new UnionFind(26);

    for (String e: equations) {
      char[] c = e.toCharArray();

      if (c[1] == '=') {
        int vertex1 = c[0] - 'a';
        int vertex2 = c[3] - 'a';
        uf.union(vertex1, vertex2);
      }
    }

    for (String e: equations) {
      char[] c = e.toCharArray();

      if (c[1] == '!') {
        int vertex1 = c[0] - 'a';
        int vertex2 = c[3] - 'a';

        if (uf.find(vertex1) == uf.find(vertex2)) {
          return false;
        }
      }
    }

    return true;
  }
}
