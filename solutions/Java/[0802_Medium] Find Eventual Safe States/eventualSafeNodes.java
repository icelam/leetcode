class Solution {
  public boolean dfs(List<List<Integer>> adjacencyList, int currentNode, boolean[] visited, boolean[] visiting) {
    if (visiting[currentNode]) {
      return true;
    }

    if (visited[currentNode]) {
      return false;
    }

    visited[currentNode] = true;
    visiting[currentNode] = true;

    for (int neighborNode: adjacencyList.get(currentNode)) {
      if (dfs(adjacencyList, neighborNode, visited, visiting)) {
        return true;
      }
    }

    visiting[currentNode] = false;
    return false;
  }

  public List<Integer> eventualSafeNodes(int[][] graph) {
    int n = graph.length;
    List<List<Integer>> adjacencyList = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adjacencyList.add(new ArrayList<>());
      for (int node : graph[i]) {
        adjacencyList.get(i).add(node);
      }
    }

    boolean[] visited = new boolean[n];
    boolean[] visiting = new boolean[n];

    for (int i = 0; i < n; i++) {
      dfs(adjacencyList, i, visited, visiting);
    }

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (!visiting[i]) {
        result.add(i);
      }
    }

    return result;
  }
}
