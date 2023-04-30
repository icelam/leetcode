class Solution {
  private int dfs(ArrayList<Integer>[][] adjacencyList, int node, int type, boolean[] visited) {
    if (visited[node]) {
      return 0;
    }

    visited[node] = true;
    int count = 1;

    for (int neighbor: adjacencyList[type][node]) {
      if (!visited[neighbor]) {
        count += dfs(adjacencyList, neighbor, type, visited);
      }
    }

    // Perform DFS on common paths when type = 1 (Alice) or type = 2 (Bob)
    if (type < 3) {
      for (int neighbor: adjacencyList[3][node]) {
        if (!visited[neighbor]) {
          count += dfs(adjacencyList, neighbor, type, visited);
        }
      }
    }

    return count;
  }

  public int maxNumEdgesToRemove(int n, int[][] edges) {
    ArrayList<Integer>[][] adjacencyList = new ArrayList[4][n + 1];

    for (int i = 1; i < 4; i++) {
      for (int j = 0; j < n + 1; j++) {
        adjacencyList[i][j] = new ArrayList<>();
      }
    }

    for (int[] edge : edges) {
      int type = edge[0];
      int node1 = edge[1];
      int node2 = edge[2];
      adjacencyList[type][node1].add(node2);
      adjacencyList[type][node2].add(node1);
    }

    // Check if Alice and Bob can visit all nodes.
    // If any of them has visited node count < n,
    // then the given graph cannot be visited by both Alice and Bob
    for (int currentType = 1; currentType <= 2; currentType++) {
      if (dfs(adjacencyList, 1, currentType, new boolean[n + 1]) < n) {
        return -1;
      }
    }

    boolean[] visited = new boolean[n + 1];
    int commonEdges = 0;

    for (int i = 1; i < n + 1; i++) {
      if (!visited[i]) {
        int count = dfs(adjacencyList, i, 3, visited);
        commonEdges += count - 1;
      }
    }

    // Minimum edges needed by Alice and Bob = (n - 1) + (n - 1) - commonEdges
    int minimumEdgesNeeded = (n - 1) * 2;
    return edges.length - minimumEdgesNeeded + commonEdges;
  }
}
