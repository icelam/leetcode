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
  public int[] lexicographicallySmallestArray(int[] nums, int limit) {
    int n = nums.length;
    int[][] indices = new int[n][2];

    for (int i = 0; i < n; i++) {
      indices[i][0] = nums[i];
      indices[i][1] = i;
    }

    Arrays.sort(indices, (a, b) -> a[0] - b[0]);

    UnionFind uf = new UnionFind(n);

    for (int i = 1; i < n; i++) {
      int[] index1 = indices[i - 1];
      int[] index2 = indices[i];

      if (index2[0] - index1[0] <= limit) {
        uf.union(index1[1], index2[1]);
      }
    }

    List<Integer>[] grouppedIndices = new ArrayList[n];
    Arrays.setAll(grouppedIndices, e -> new ArrayList<>());

    for (int i = 0; i < n; i++) {
      grouppedIndices[uf.find(i)].add(i);
    }

    int[] result = new int[n];

    for (List<Integer> currentIndices: grouppedIndices) {
      int m = currentIndices.size();

      if (m == 0) {
        continue;
      }

      Integer[] values = new Integer[m];

      for (int i = 0; i < m; i++) {
        values[i] = nums[currentIndices.get(i)];
      }

      Arrays.sort(values);

      for (int i = 0; i < m; i++) {
        result[currentIndices.get(i)] = values[i];
      }
    }

    return result;
  }
}
