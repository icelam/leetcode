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
  public int numberOfGoodPaths(int[] vals, int[][] edges) {
    int n = vals.length;

    if (edges.length == 0) {
      return n;
    }

    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    for (int[] edge: edges) {
      int a = edge[0];
      int b = edge[1];
      adjacencyList.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
      adjacencyList.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
    }

    TreeMap<Integer, List<Integer>> valuesToNodes = new TreeMap<>();

    for (int i = 0; i < n; i++) {
      valuesToNodes.computeIfAbsent(vals[i], value -> new ArrayList<Integer>()).add(i);
    }

    UnionFind uf = new UnionFind(n);
    int goodPaths = 0;

    for (int value: valuesToNodes.keySet()) {
      for (int node: valuesToNodes.get(value)) {
        if (!adjacencyList.containsKey(node)) {
          continue;
        }

        for (int neighbor: adjacencyList.get(node)) {
          if (vals[node] >= vals[neighbor]) {
            uf.union(node, neighbor);
          }
        }
      }

      Map<Integer, Integer> count = new HashMap<>();

      for (int i: valuesToNodes.get(value)) {
        int group = uf.find(i);
        count.put(group, count.getOrDefault(group, 0) + 1);
      }

      for (int group: count.keySet()) {
        int size = count.get(group);
        goodPaths += size * (size + 1) / 2;
      }
    }

    return goodPaths;
  }
}
