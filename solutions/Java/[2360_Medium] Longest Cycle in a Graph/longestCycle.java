class Solution {
  private int result;
  private boolean[] visited;

  private void dfs(int node, int[] edges, HashMap<Integer, Integer> distance) {
    visited[node] = true;
    int neighbor = edges[node];

    if (neighbor != -1) {
      if (!visited[neighbor]) {
        distance.put(neighbor, distance.get(node) + 1);
        dfs(neighbor, edges, distance);
      } else if (distance.containsKey(neighbor)) {
        result = Math.max(result, distance.get(node) - distance.get(neighbor) + 1);
      }
    }
  }

  public int longestCycle(int[] edges) {
    int n = edges.length;
    result = -1;
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        HashMap<Integer, Integer> distance = new HashMap<>();
        distance.put(i, 1);
        dfs(i, edges, distance);
      }
    }

    return result;
  }
}
