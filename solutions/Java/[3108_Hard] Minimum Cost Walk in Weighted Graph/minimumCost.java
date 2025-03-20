class Solution {
  private ArrayList<int[]>[] generateAdjacencyList(int n, int[][] edges) {
    ArrayList<int[]>[] adjacencyList = new ArrayList[n];
    Arrays.setAll(adjacencyList, i -> new ArrayList<>());

    for (int[] edge : edges) {
      int node1 = edge[0];
      int node2 = edge[1];
      int weight = edge[2];
      adjacencyList[node1].add(new int[] {node2, weight});
      adjacencyList[node2].add(new int[] {node1, weight});
    }

    return adjacencyList;
  }

  private int dfs(ArrayList<int[]>[] adjacencyList, int currentNode, int currentId, int[] componentId) {
    componentId[currentNode] = currentId;
    int currentCost = -1;

    for (int[] edge : adjacencyList[currentNode]) {
      currentCost &= edge[1];

      if (componentId[edge[0]] < 0) {
        currentCost &= dfs(adjacencyList, edge[0], currentId, componentId);
      }
    }

    return currentCost;
  }

  public int[] minimumCost(int n, int[][] edges, int[][] query) {
    ArrayList<int[]>[] adjacencyList = generateAdjacencyList(n, edges);
    List<Integer> costs = new ArrayList<>();
    int[] componentId = new int[n];
    Arrays.fill(componentId, -1);

    for (int i = 0; i < n; i++) {
      if (componentId[i] < 0) {
        costs.add(dfs(adjacencyList, i, costs.size(), componentId));
      }
    }

    int[] result = new int[query.length];

    for (int i = 0; i < query.length; i++) {
      int node1 = query[i][0];
      int node2 = query[i][1];
      result[i] = componentId[node1] != componentId[node2] ? -1 : costs.get(componentId[node1]);
    }

    return result;
  }
}
