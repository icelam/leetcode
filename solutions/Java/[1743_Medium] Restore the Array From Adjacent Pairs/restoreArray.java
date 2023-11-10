class Solution {
  public int[] restoreArray(int[][] adjacentPairs) {
    int n = adjacentPairs.length + 1;
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    for (int[] edge: adjacentPairs) {
      int a = edge[0];
      int b = edge[1];
      adjacencyList.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
      adjacencyList.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
    }

    int[] result = new int[n];

    for (int node: adjacencyList.keySet()) {
      if (adjacencyList.get(node).size() == 1) {
        result[0] = node;
        break;
      }
    }

    for (int i = 1; i < n; i++) {
      List<Integer> neighbours = adjacencyList.get(result[i - 1]);

      for (int node: neighbours) {
        if (i == 1 || node != result[i - 2]) {
          result[i] = node;
          break;
        }
      }
    }

    return result;
  }
}
