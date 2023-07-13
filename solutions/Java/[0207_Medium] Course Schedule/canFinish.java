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

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adjacencyList = new ArrayList<>();

    for (int i = 0; i < numCourses; i++) {
      adjacencyList.add(new ArrayList<>());
    }

    for (int[] p : prerequisites) {
      adjacencyList.get(p[1]).add(p[0]);
    }

    boolean[] visited = new boolean[numCourses];
    boolean[] visiting = new boolean[numCourses];

    for (int i = 0; i < numCourses; i++) {
      if (dfs(adjacencyList, i, visited, visiting)) {
        return false;
      }
    }

    return true;
  }
}
