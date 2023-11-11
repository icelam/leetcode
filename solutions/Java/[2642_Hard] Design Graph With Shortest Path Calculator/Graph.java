class Graph {
  private int size;
  private Map<Integer, List<int[]>> directedEdges;

  public Graph(int n, int[][] edges) {
    size = n;
    directedEdges = new HashMap<>();

    for (int[] edge: edges) {
      directedEdges.computeIfAbsent(edge[0], value -> new ArrayList<int[]>()).add(new int[]{edge[1], edge[2]});
    }
  }

  public void addEdge(int[] edge) {
    directedEdges.computeIfAbsent(edge[0], value -> new ArrayList<int[]>()).add(new int[]{edge[1], edge[2]});
  }

  // Dijkstra's Algorithm
  private int dijkstra(int start, int end) {
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    priorityQueue.add(new int[]{start, 0});

    int[] costs = new int[size];
    Arrays.fill(costs, Integer.MAX_VALUE);
    costs[start] = 0;

    while (!priorityQueue.isEmpty()) {
      int[] currentInfo = priorityQueue.remove();
      int currentNode = currentInfo[0];
      int currentCost = currentInfo[1];

      if (currentCost > costs[currentNode]) {
        continue;
      }

      if (currentNode == end) {
        return currentCost;
      }

      if (!directedEdges.containsKey(currentNode)) {
        continue;
      }

      for (int[] edge: directedEdges.get(currentNode)) {
        int neighborNode = edge[0];
        int neighborCost = edge[1];

        if (costs[neighborNode] > currentCost + neighborCost) {
          costs[neighborNode] = currentCost + neighborCost;
          priorityQueue.add(new int[]{neighborNode, costs[neighborNode]});
        }
      }
    }

    return -1;
  }

  public int shortestPath(int node1, int node2) {
    return dijkstra(node1, node2);
  }
}
