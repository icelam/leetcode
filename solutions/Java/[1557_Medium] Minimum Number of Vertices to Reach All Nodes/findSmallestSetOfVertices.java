class Solution {
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    boolean[] verticesWithIncomingEdges = new boolean[n];

    for (List<Integer> edge: edges) {
      verticesWithIncomingEdges[edge.get(1)] = true;
    }

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (!verticesWithIncomingEdges[i]) {
        result.add(i);
      }
    }

    return result;
  }
}
