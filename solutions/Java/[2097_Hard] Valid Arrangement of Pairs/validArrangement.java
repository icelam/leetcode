class Solution {
  private List<Integer> result;
  private Map<Integer, PriorityQueue<Integer>> graph;

  private void dfs(Integer source) {
    PriorityQueue<Integer> neighbor = graph.get(source);

    while (neighbor != null && neighbor.size() > 0) {
      Integer destination = neighbor.remove();
      dfs(destination);
    }

    result.add(source);
  }


  public int[][] validArrangement(int[][] pairs) {
    int n = pairs.length;
    // Use Hierholzer's Algorithm to find Eulerian path
    result = new ArrayList<>();
    graph = new HashMap<>();
    HashMap<Integer, Integer> inDegree = new HashMap<>();
    HashMap<Integer, Integer> outDegree = new HashMap<>();

    for (int[] p: pairs) {
      PriorityQueue<Integer> neighbor = graph.computeIfAbsent(p[0], k -> new PriorityQueue<>());
      neighbor.add(p[1]);
      outDegree.put(p[0], outDegree.getOrDefault(p[0], 0) + 1);
      inDegree.put(p[1], inDegree.getOrDefault(p[1], 0) + 1);
    }

    int startNode = -1;

    for (int node: outDegree.keySet()) {
      if (outDegree.get(node) == inDegree.getOrDefault(node, 0) + 1) {
        startNode = node;
        break;
      }
    }

    if (startNode == -1) {
      startNode = pairs[0][0];
    }

    dfs(startNode);
    Collections.reverse(result);

    int[][] pairedResult = new int[n][2];

    for (int i = 1; i <= n; i++) {
      pairedResult[i - 1] = new int[] {result.get(i - 1), result.get(i)};
    }

    return pairedResult;
  }
}
