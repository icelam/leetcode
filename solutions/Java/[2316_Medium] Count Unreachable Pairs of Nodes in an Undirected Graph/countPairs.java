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
  public long countPairs(int n, int[][] edges) {
    UnionFind uf = new UnionFind(n);

    for (int[] e: edges) {
      uf.union(e[0], e[1]);
    }

    HashMap<Integer, Integer> groupSize = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int group = uf.find(i);
      groupSize.put(group, groupSize.getOrDefault(group, 0) + 1);
    }

    long result = 0;
    long remain = n;

    for (int size: groupSize.values()) {
      result += size * (remain - size);
      remain -= size;
    }

    return result;
  }
}
