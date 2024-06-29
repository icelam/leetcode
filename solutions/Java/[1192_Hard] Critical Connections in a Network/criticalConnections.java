class Solution {
  private Map<Integer, List<Integer>> adjacencyList;
  private int[] lowlink;
  private List<List<Integer>> result;

  public void generateAdjacencyList(List<List<Integer>> connections) {
    for (List<Integer> edge: connections) {
      int node1 = edge.get(0);
      int node2 = edge.get(1);

      adjacencyList.putIfAbsent(node1, new ArrayList<>());
      adjacencyList.get(node1).add(node2);

      adjacencyList.putIfAbsent(node2, new ArrayList<>());
      adjacencyList.get(node2).add(node1);
    }
  }

  public int tarjan(int node, int index, int parent) {
    if (lowlink[node] == -1) {
      lowlink[node] = index;

      for (int neighbor: adjacencyList.get(node)) {
        if (neighbor == parent) {
          continue;
        }

        int lowestIndex = tarjan(neighbor, index + 1, node);

        if (lowestIndex > index) {
          result.add(Arrays.asList(neighbor, node));
        } else {
          lowlink[node] = Math.min(lowlink[node], lowestIndex);
        }
      }
    }

    return lowlink[node];
  }

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    result = new ArrayList<>();

    adjacencyList = new HashMap<Integer, List<Integer>>();
    generateAdjacencyList(connections);

    lowlink = new int[n];
    Arrays.fill(lowlink, -1);

    tarjan(0, 0, -1);
    return result;
  }
}
