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
  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    UnionFind uf = new UnionFind(s.length());

    for (List<Integer> edge: pairs) {
      int vertex1 = edge.get(0);
      int vertex2 = edge.get(1);

      uf.union(vertex1, vertex2);
    }

    HashMap<Integer, List<Integer>> grouppedVertices = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      int group = uf.find(i);

      if (grouppedVertices.containsKey(group)) {
        List<Integer> list = grouppedVertices.get(group);
        list.add(i);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        grouppedVertices.put(group, list);
      }
    }

    char[] result = new char[s.length()];

    for (List<Integer> vertices: grouppedVertices.values()) {
      List<Integer> swapPositions = new ArrayList<>();
      swapPositions.addAll(vertices);
      Collections.sort(swapPositions, ((a, b) -> s.charAt(a) - s.charAt(b)));

      for (int i = 0; i < vertices.size(); i++) {
        result[vertices.get(i)] = s.charAt(swapPositions.get(i));
      }
    }

    return new String(result);
  }
}
