class Solution {
   private static int MOD = (int) (1e9 + 7);

  private List<int[]>[] generateAdjacencyList(int n, int[][] edges) {
    List<int[]>[] adjacencyList = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      adjacencyList[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      int node1 = edge[0];
      int node2 = edge[1];
      int weight = edge[2];
      adjacencyList[node1].add(new int[]{node2, weight});
      adjacencyList[node2].add(new int[]{node1, weight});
    }

    return adjacencyList;
  }

  private int dijkstra(List<int[]>[] graph, int start, int end) {
    int n = graph.length;

    PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
    priorityQueue.add(new long[]{start, 0});

    long[] costs = new long[n];
    Arrays.fill(costs, Long.MAX_VALUE);
    costs[start] = 0;

    int[] pathCount = new int[n];
    pathCount[0] = 1;

    while (!priorityQueue.isEmpty()) {
      long[] currentInfo = priorityQueue.remove();
      int currentNode = (int) currentInfo[0];
      long currentCost = currentInfo[1];

      if (currentCost > costs[currentNode]) {
        continue;
      }

      for (int[] neighbor: graph[currentNode]) {
        int neighborNode = neighbor[0];
        int neighborCost = neighbor[1];

        if (currentCost + neighborCost < costs[neighborNode]) {
          costs[neighborNode] = currentCost + neighborCost;
          pathCount[neighborNode] = pathCount[currentNode];
          priorityQueue.add(new long[]{neighborNode, costs[neighborNode]});
        } else if (currentCost + neighborCost == costs[neighborNode]) {
          pathCount[neighborNode] = (pathCount[neighborNode] + pathCount[currentNode]) % MOD;
        }
      }
    }

    return pathCount[end];
  }

  public int countPaths(int n, int[][] roads) {
    return dijkstra(generateAdjacencyList(n, roads), 0, n - 1);
  }
}
