class Solution {
  private HashMap<Integer, HashSet<Integer>> generateAdjacencyList(int n, int[][] edges) {
    HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();

    for (int i = 0; i < n; i++) {
      adjacencyList.put(i, new HashSet<>());
    }

    for (int[] edge: edges) {
      int node1 = edge[0];
      int node2 = edge[1];
      adjacencyList.get(node1).add(node2);
      adjacencyList.get(node2).add(node1);
    }

    return adjacencyList;
  }

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> result = new ArrayList<>();

    if (n == 1) {
      result.add(0);
      return result;
    }

    HashMap<Integer, HashSet<Integer>> adjacencyList = generateAdjacencyList(n, edges);
    Queue<Integer> queue = new LinkedList<>();

    /**
     * Given the fact that removing all leaves of a MST will still result in a MST,
     * we can remove leaves layer by layer which results in root of MST at the end.
     */
    for (int node: adjacencyList.keySet()) {
      if (adjacencyList.get(node).size() == 1) {
        queue.add(node);
      }
    }

    while (!queue.isEmpty()) {
      result.clear();
      int batchSize = queue.size();

      for (int i = 0; i < batchSize; i++) {
        int currentNode = queue.remove();
        result.add(currentNode);

        for (int nextNode: adjacencyList.get(currentNode)) {
          HashSet<Integer> nextNeighbors = adjacencyList.get(nextNode);
          nextNeighbors.remove(currentNode);

          if (nextNeighbors.size() == 1) {
            queue.offer(nextNode);
          }
        }
      }
    }

    return result;
  }
}
