class Solution {
  private int[] topologicalSort(int[][] edges, int k) {
    List<Integer>[] graph = new ArrayList[k + 1];
    Arrays.setAll(graph, e -> new ArrayList<>());
    int[] indegree = new int[k + 1];

    for (int[] currentEdge: edges) {
      graph[currentEdge[0]].add(currentEdge[1]);
      indegree[currentEdge[1]]++;
    }

    List<Integer> order = new ArrayList<Integer>();
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 1; i <= k; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int x = queue.remove();
      order.add(x);

      for (int y: graph[x]) {
        indegree[y]--;

        if (indegree[y] == 0) {
          queue.add(y);
        }
      }
    }

    return order.stream().mapToInt(x -> x).toArray();
  }

  public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
    int[] rows = topologicalSort(rowConditions, k);
    int[] columns = topologicalSort(colConditions, k);

    if (rows.length < k || columns.length < k) {
      return new int[0][0];
    }

    int[][] matrix = new int[k][k];

    for (int i = 0; i < k; i++) {
      for (int j = 0; j < k; j++) {
        if (rows[i] == columns[j]) {
          matrix[i][j] = rows[i];
        }
      }
    }

    return matrix;
  }
}
