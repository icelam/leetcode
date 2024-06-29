class Solution {
  private List<Integer>[] generateAdjacencyList(int n, int[][] edges) {
    List<Integer>[] adjacencyList = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      adjacencyList[i] = new ArrayList<>();
    }

    for (int[] edge: edges) {
      int node1 = edge[0];
      int node2 = edge[1];
      adjacencyList[node1].add(node2);
    }

    return adjacencyList;
  }

  private void dfs(int currentNode, int start, List<Integer>[] adjacencyList, int[] visited, List<List<Integer>> ancestors) {
    // There is no need to reinitialize the vis array before each DFS.
    // We will run DFS n times, and the start of each DFS is different.
    // Using this condition, when currentNode is accessed, mark vis[currentNode]=start,
    // indicating that currentNode is the node accessed in this round of DFS.
    // When we visit a certain childNode, if we find vis[childNode]=start, it means that childNode
    // has been visited, otherwise it has not been visited.
    visited[currentNode] = start;

    for (int childNode: adjacencyList[currentNode]) {
      if (visited[childNode] != start) {
        ancestors.get(childNode).add(start);
        dfs(childNode, start, adjacencyList, visited, ancestors);
      }
    }
  }

  public List<List<Integer>> getAncestors(int n, int[][] edges) {
    List<Integer>[] adjacencyList = generateAdjacencyList(n, edges);

    List<List<Integer>> ancestors = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      ancestors.add(new ArrayList<>());
    }

    int[] visited = new int[n];
    Arrays.fill(visited, -1);

    for (int start = 0; start < n; start++) {
      dfs(start, start, adjacencyList, visited, ancestors);
    }

    return ancestors;
  }
}
