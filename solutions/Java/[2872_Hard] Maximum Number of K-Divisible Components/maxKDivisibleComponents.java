class Solution {
  private int splitCount = 0;

  private List<Integer>[] generateAdjacencyList(int n, int[][] edges) {
    List<Integer>[] adjacencyList = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      adjacencyList[i] = new ArrayList<>();
    }

    for (int[] edge: edges) {
      int node1 = edge[0];
      int node2 = edge[1];
      adjacencyList[node1].add(node2);
      adjacencyList[node2].add(node1);
    }

    return adjacencyList;
  }

  private int dfs(List<Integer>[] adjacencyList, int[] values, int k, int currentNode, int parentNode) {
    int sum = 0;

    for (int neighborNode: adjacencyList[currentNode]) {
      if (neighborNode == parentNode) {
        continue;
      }

      sum += dfs(adjacencyList, values, k, neighborNode, currentNode);
    }

    sum += values[currentNode];
    sum %= k;

    if (sum == 0) {
      splitCount++;
    }

    return sum;
  }

  public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
    List<Integer>[] adjacencyList = generateAdjacencyList(n, edges);
    dfs(adjacencyList, values, k, 0, -1);
    return splitCount;
  }
}
