class UnionFind {
  private int[] group;

  public UnionFind(int size) {
    group = new int[size];

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

    if (group[group1] > group[group2]) {
      group[group1] = group2;
    } else {
      group[group2] = group1;
    }

    return true;
  }
}

class Solution {
  public String smallestEquivalentString(String s1, String s2, String baseStr) {
    UnionFind uf = new UnionFind(26);
    int n = s1.length();
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();

    for (int i = 0; i < n; i++) {
      uf.union(c1[i] - 'a', c2[i] - 'a');
    }

    StringBuilder result = new StringBuilder();
    for (char c: baseStr.toCharArray()) {
      result.append((char) (uf.find(c - 'a') + 'a'));
    }

    return result.toString();
  }
}
