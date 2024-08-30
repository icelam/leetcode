class Solution {
  private static final int MAX_WEIGHT = (int) 2e9;

  public List<int[]>[] generateGraph(int n, int[][] edges) {
    List<int[]>[] graph = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      if (edge[2] != -1) {
        graph[edge[0]].add(new int[]{edge[1], edge[2]});
        graph[edge[1]].add(new int[]{edge[0], edge[2]});
      }
    }

    return graph;
  }

  private int dijkstra(List<int[]>[] graph, int start, int end) {
    int n = graph.length;

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    priorityQueue.add(new int[]{start, 0});

    int[] costs = new int[n];
    Arrays.fill(costs, MAX_WEIGHT);
    costs[start] = 0;

    while (!priorityQueue.isEmpty()) {
      int[] currentInfo = priorityQueue.remove();
      int currentNode = currentInfo[0];
      int currentCost = currentInfo[1];

      if (currentCost > costs[currentNode]) {
        continue;
      }

      for (int[] neighbor: graph[currentNode]) {
        int neighborNode = neighbor[0];
        int neighborCost = neighbor[1];

        if (currentCost + neighborCost < costs[neighborNode]) {
          costs[neighborNode] = currentCost + neighborCost;
          priorityQueue.add(new int[]{neighborNode, costs[neighborNode]});
        }
      }
    }

    return costs[end];
  }

  public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
    List<int[]>[] graph = generateGraph(n, edges);

    int shortestPathDistance = dijkstra(graph, source, destination);

    if (shortestPathDistance < target) {
      return new int[0][0];
    }

    boolean isTargetMatch = shortestPathDistance == target;

    for (int[] edge: edges) {
      if (edge[2] != -1) {
        continue;
      }

      edge[2] = isTargetMatch ? MAX_WEIGHT : 1;
      graph[edge[0]].add(new int[]{edge[1], edge[2]});
      graph[edge[1]].add(new int[]{edge[0], edge[2]});

      if (!isTargetMatch) {
        int newShortestPathDistance = dijkstra(graph, source, destination);

        if (newShortestPathDistance <= target) {
          isTargetMatch = true;
          edge[2] += target - newShortestPathDistance;
        }
      }
    }

    if (isTargetMatch) {
      return edges;
    }

    return new int[0][0];
  }
}
