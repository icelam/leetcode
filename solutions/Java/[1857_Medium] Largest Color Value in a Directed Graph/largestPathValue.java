class Solution {
  private int result;
  private int[][] dp;

  private boolean dfs(HashMap<Integer, List<Integer>> adjacencyList, char[] nodeColors, int[] visited, int currentNode) {
    // Visited
    if (visited[currentNode] == -1) {
      return true;
    }
    // cycle
    if (visited[currentNode] == 1) {
      return false;
    }

    visited[currentNode] = 1;


    if (adjacencyList.containsKey(currentNode)) {
      for (int neighborNode: adjacencyList.get(currentNode)) {
        if (!dfs(adjacencyList, nodeColors, visited, neighborNode)) {
          return false;
        }

        for (int i = 0; i < 26; i++) {
          dp[currentNode][i] = Math.max(dp[currentNode][i], dp[neighborNode][i]);
        }
      }
    }

    visited[currentNode] = -1;
    dp[currentNode][nodeColors[currentNode] - 'a'] += 1;
    result = Math.max(dp[currentNode][nodeColors[currentNode] - 'a'], result);
    return true;
  }

  public int largestPathValue(String colors, int[][] edges) {
    char[] nodeColors = colors.toCharArray();
    int n = nodeColors.length;
    result = 0;
    dp = new int[n][26];
    int[] visited = new int[n];

    HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

    for (int[] edge: edges) {
      int a = edge[0];
      int b = edge[1];
      adjacencyList.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
    }

    for (int i = 0; i < n; i++) {
      if (!dfs(adjacencyList, nodeColors, visited, i)) {
        return -1;
      }
    }

    return result;
  }
}
