class Solution {
  private boolean[][] topologicalSort(int[][] edges, int n) {
    List<Integer>[] graph = new ArrayList[n];
    Arrays.setAll(graph, e -> new ArrayList<>());
    int[] indegree = new int[n];

    for (int[] currentEdge: edges) {
      graph[currentEdge[0]].add(currentEdge[1]);
      indegree[currentEdge[1]]++;
    }

    boolean[][] comesBefore = new boolean[n][n];
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int current = queue.remove();

      for (int neighbor: graph[current]) {
        comesBefore[current][neighbor] = true;

        for (int i = 0; i < n; i++) {
          comesBefore[i][neighbor] |= comesBefore[i][current];
        }

        indegree[neighbor]--;

        if (indegree[neighbor] == 0) {
          queue.add(neighbor);
        }
      }
    }

    return comesBefore;
  }

  public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
    boolean[][] courseOrder = topologicalSort(prerequisites, numCourses);
    List<Boolean> result = new ArrayList<>();

    for (int[] q: queries) {
      result.add(courseOrder[q[0]][q[1]]);
    }

    return result;
  }
}
