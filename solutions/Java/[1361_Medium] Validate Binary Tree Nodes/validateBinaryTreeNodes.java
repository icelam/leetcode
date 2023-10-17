class Solution {
  public boolean dfs(int node, int[] leftChild, int[] rightChild, boolean[] visited) {
    if (node == -1) {
      return true;
    }

    if (visited[node]) {
      return false;
    }

    visited[node] = true;

    boolean isLeftTreeValid = dfs(leftChild[node], leftChild, rightChild, visited);
    if (!isLeftTreeValid) {
      return false;
    }

    boolean isRightTreeValid = dfs(rightChild[node], leftChild, rightChild, visited);
    return isRightTreeValid;
  }

  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    int[] indegree = new int[n];

    for (int i = 0; i < n; i++) {
      if (leftChild[i] != -1) {
        indegree[leftChild[i]]++;
      }

      if (rightChild[i] != -1) {
        indegree[rightChild[i]]++;
      }
    }

    int rootIndex = -1;

    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        rootIndex = i;
        break;
      }
    }

    if (rootIndex == -1) {
      return false;
    }

    boolean[] visited = new boolean[n];

    // Check for loop
    if (!dfs(rootIndex, leftChild, rightChild, visited)) {
      return false;
    }

    // Check for node that is disconnected from root
    for (boolean hasVisited: visited) {
      if (!hasVisited) {
        return false;
      }
    }

    return true;
  }
}
