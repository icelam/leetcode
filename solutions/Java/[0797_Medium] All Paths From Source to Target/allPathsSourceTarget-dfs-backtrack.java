class Solution {
  public void dfs(int[][] graph, List<List<Integer>> result, List<Integer> path, int origin, int destination) {
    if (origin == destination) {
      result.add(new ArrayList<>(path));
      return;
    }

    for (int neighbor: graph[origin]) {
      path.add(neighbor);
      dfs(graph, result, path, neighbor, destination);
      path.remove(path.size() - 1);
    }
  }

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    int originNode = 0;
    int destinationNode = graph.length - 1;

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    path.add(originNode);

    dfs(graph, result, path, originNode, destinationNode);
    return result;
  }
}
