class Solution {
  private List<Integer>[] generateAdjacencyList(int n, int[][] edges) {
    List<Integer>[] adjacencyList = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      adjacencyList[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      int node1 = edge[0];
      int node2 = edge[1];
      adjacencyList[node1].add(node2);
      adjacencyList[node2].add(node1);
    }

    return adjacencyList;
  }

  private void dfs(List<Integer>[] adjacencyList, int currentNode, boolean[] visited, int[] counts) {
    visited[currentNode] = true;
    // Increment node count
    counts[0]++;
    // Increment edge count
    counts[1] += adjacencyList[currentNode].size();

    for (int childNode : adjacencyList[currentNode]) {
      if (!visited[childNode]) {
        dfs(adjacencyList, childNode, visited, counts);
      }
    }
  }

  public int countCompleteComponents(int n, int[][] edges) {
    List<Integer>[] adjacencyList = generateAdjacencyList(n, edges);
    boolean[] visited = new boolean[n];
    int result = 0;

    for (int i = 0; i < n; i++) {
      if (visited[i]) {
        continue;
      }

      int[] counts = new int[2];
      dfs(adjacencyList, i, visited, counts);

      // In a complete component, there exists an edge between any two points,
      // which is equivalent to the number of pairs of nodes in the graph.
      // Also equals to number of choices for selecting 2 points from N points (nC2):
      // edgeCount = (nodeCount * (nodeCount − 1)) / 2
      // Since one edge was counted twice during the DFS, condition becomes:
      // edgeCount = (nodeCount * (nodeCount − 1))
      if (counts[1] == counts[0] * (counts[0] - 1)) {
        result++;
      }
    }

    return result;
  }
}
