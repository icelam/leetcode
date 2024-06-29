class Solution {
  private void buildGraph(Map<Integer, List<Integer>> adjacencyList, TreeNode currentNode, TreeNode parentNode) {
    if (currentNode == null) {
      return;
    }

    adjacencyList.putIfAbsent(currentNode.val, new ArrayList<>());

    if (parentNode != null) {
      adjacencyList.get(currentNode.val).add(parentNode.val);
    }

    if (currentNode.left != null) {
      adjacencyList.get(currentNode.val).add(currentNode.left.val);
      buildGraph(adjacencyList, currentNode.left, currentNode);
    }

    if (currentNode.right != null) {
      adjacencyList.get(currentNode.val).add(currentNode.right.val);
      buildGraph(adjacencyList, currentNode.right, currentNode);
    }
  }

  private void dfs(Map<Integer, List<Integer>> adjacencyList, int currentNode, int k, List<Integer> result, HashSet<Integer> visited) {
    if (k == 0) {
      result.add(currentNode);
    }

    visited.add(currentNode);

    for (int neighborNode: adjacencyList.get(currentNode)) {
      if (!visited.contains(neighborNode)) {
        dfs(adjacencyList, neighborNode, k - 1, result, visited);
      }
    }
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    buildGraph(adjacencyList, root, null);

    List<Integer> result = new ArrayList<>();
    dfs(adjacencyList, target.val, k, result, new HashSet<Integer>());

    return result;
  }
}
