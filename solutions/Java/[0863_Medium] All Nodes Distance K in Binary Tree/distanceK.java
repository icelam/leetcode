class Solution {
  private void buildGraph(Map<Integer, List<Integer>> adjencyList, TreeNode currentNode, TreeNode parentNode) {
    if (currentNode == null) {
      return;
    }

    adjencyList.putIfAbsent(currentNode.val, new ArrayList<>());

    if (parentNode != null) {
      adjencyList.get(currentNode.val).add(parentNode.val);
    }

    if (currentNode.left != null) {
      adjencyList.get(currentNode.val).add(currentNode.left.val);
      buildGraph(adjencyList, currentNode.left, currentNode);
    }

    if (currentNode.right != null) {
      adjencyList.get(currentNode.val).add(currentNode.right.val);
      buildGraph(adjencyList, currentNode.right, currentNode);
    }
  }

  private void dfs(Map<Integer, List<Integer>> adjencyList, int currentNode, int k, List<Integer> result, HashSet<Integer> visited) {
    if (k == 0) {
      result.add(currentNode);
    }

    visited.add(currentNode);

    for (int neighborNode: adjencyList.get(currentNode)) {
      if (!visited.contains(neighborNode)) {
        dfs(adjencyList, neighborNode, k - 1, result, visited);
      }
    }
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<Integer, List<Integer>> adjencyList = new HashMap<>();
    buildGraph(adjencyList, root, null);

    List<Integer> result = new ArrayList<>();
    dfs(adjencyList, target.val, k, result, new HashSet<Integer>());

    return result;
  }
}
