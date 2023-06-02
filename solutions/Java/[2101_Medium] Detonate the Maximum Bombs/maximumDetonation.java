class Solution {
  private boolean isBombInRange(int[] bomb1, int[] bomb2) {
    double distance = Math.sqrt(Math.pow((bomb2[0] - bomb1[0]), 2) + Math.pow((bomb2[1] - bomb1[1]), 2));
    return bomb1[2] >= distance;
  }

  private int dfs(Map<Integer, List<Integer>> adjacencyList, boolean[] visited, int start) {
    int count = 1;
    visited[start] = true;

    if (adjacencyList.containsKey(start)) {
      for (int neighbor: adjacencyList.get(start)) {
        if (!visited[neighbor]) {
          count += dfs(adjacencyList, visited, neighbor);
        }
      }
    }

    return count;
  }

  public int maximumDetonation(int[][] bombs) {
    int n = bombs.length;
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j || !isBombInRange(bombs[i], bombs[j])) {
          continue;
        }

        adjacencyList.putIfAbsent(i, new ArrayList<>());
        // Directed graph since bomb[i] can trigger bomb[j]
        // does not necessary means bomb[j] can trigger bomb[i]
        adjacencyList.get(i).add(j);
      }
    }

    int result = 1;

    for (int start: adjacencyList.keySet()) {
      boolean[] visited = new boolean[n];
      int count = 0;

      result = Math.max(result, dfs(adjacencyList, visited, start));
    }

    return result;
  }
}
