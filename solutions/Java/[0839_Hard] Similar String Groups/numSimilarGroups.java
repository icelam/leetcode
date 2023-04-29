class Solution {
  public boolean isSimilar(String s1, String s2) {
    int differenceCount = 0;

    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        differenceCount++;
      }
    }

    return differenceCount == 0 || differenceCount == 2;
  }

  public void dfs(Map<Integer, List<Integer>> adjencyList, boolean[] visited, int node) {
    visited[node] = true;

    if (!adjencyList.containsKey(node)) {
      return;
    }

    for (int neighbor : adjencyList.get(node)) {
      if (!visited[neighbor]) {
        visited[neighbor] = true;
        dfs(adjencyList, visited, neighbor);
      }
    }
  }

  public int numSimilarGroups(String[] strs) {
    int n = strs.length;
    Map<Integer, List<Integer>> adjencyList = new HashMap<>();

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (isSimilar(strs[i], strs[j])) {
          adjencyList.putIfAbsent(i, new ArrayList<>());
          adjencyList.get(i).add(j);

          adjencyList.putIfAbsent(j, new ArrayList<>());
          adjencyList.get(j).add(i);
        }
      }
    }

    boolean[] visited = new boolean[n];
    int count = 0;

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(adjencyList, visited, i);
        count++;
      }
    }

    return count;
  }
}
