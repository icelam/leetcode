class Solution {
  private List<Integer>[] graph;
  private final List<Integer> nodes = new ArrayList<>();
  private int[] time;
  private int[] colors;
  private int clock;

  private boolean isBipartite(int node, int currentColor) {
    nodes.add(node);
    colors[node] = currentColor;

    for (int neighbor: graph[node]) {
      if (colors[neighbor] == currentColor || colors[neighbor] == 0 && !isBipartite(neighbor, -currentColor)) {
        return false;
      }
    }

    return true;
  }

  private int bfs(int start) {
    int depth = 0;
    clock++;
    time[start] = clock;

    List<Integer>  queue = new ArrayList<Integer>();
    queue.add(start);

    while (!queue.isEmpty()) {
      List<Integer> nextQueue = new ArrayList<>();

      for (int currentNode: queue) {
        for (int neighbor: graph[currentNode]) {
          if (time[neighbor] != clock) {
            time[neighbor] = clock;
            nextQueue.add(neighbor);
          }
        }
      }

      depth++;
      queue = nextQueue;
    }

    return depth;
  }

  public int magnificentSets(int n, int[][] edges) {
    graph = new ArrayList[n];
    Arrays.setAll(graph, e -> new ArrayList<>());

    for (int[] e: edges) {
      int x = e[0] - 1;
      int y = e[1] - 1;
      graph[x].add(y);
      graph[y].add(x);
    }

    time = new int[n];
    colors = new int[n];
    int result = 0;

    for (int i = 0; i < n; i++) {
      if (colors[i] != 0) {
        continue;
      }

      nodes.clear();

      if (!isBipartite(i, 1)) {
        return -1;
      }

      int maxDepth = 0;

      for (int currentNode: nodes) {
        maxDepth = Math.max(maxDepth, bfs(currentNode));
      }

      result += maxDepth;
    }

    return result;
  }
}
