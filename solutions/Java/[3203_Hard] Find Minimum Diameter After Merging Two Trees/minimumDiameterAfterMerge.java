class Solution {
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

  private int dfs(List<Integer>[] adjacencyList, int currentNode, int parentNode, int[] diameter) {
    int longestPath = 0;

    for (int neighborNode: adjacencyList[currentNode]) {
      if (neighborNode != parentNode) {
        int subPath = dfs(adjacencyList, neighborNode, currentNode, diameter) + 1;
        diameter[0] = Math.max(diameter[0], longestPath + subPath);
        longestPath = Math.max(longestPath, subPath);
      }
    }

    return longestPath;
  }

  private int getDiameter(int[][] edges) {
    List<Integer>[] adjacencyList = generateAdjacencyList(edges.length + 1, edges);

    int[] diameter = new int[]{0};
    dfs(adjacencyList, 0, -1, diameter);
    return diameter[0];
  }

  public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
    int diameter1 = getDiameter(edges1);
    int diameter2 = getDiameter(edges2);
    int maxUnconnectedDiameter = Math.max(diameter1, diameter2);
    int connectedDiameter = ((diameter1 + 1) / 2) + ((diameter2 + 1) / 2) + 1;
    return Math.max(maxUnconnectedDiameter, connectedDiameter);
  }
}
