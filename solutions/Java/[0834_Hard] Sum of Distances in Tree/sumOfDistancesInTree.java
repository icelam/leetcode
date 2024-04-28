class Solution {
  private List<Integer>[] adjacencyList;
  private int[] result;
  private int[] treeSize;

  public void postOrder(int node, int parent) {
    for (int neighbor: adjacencyList[node]) {
      if (neighbor != parent) {
        postOrder(neighbor, node);
        treeSize[node] += treeSize[neighbor];
        result[node] += result[neighbor] + treeSize[neighbor];
      }
    }
  }

  public void preOrder(int node, int parent, int n) {
    for (int neighbor: adjacencyList[node]) {
      if (neighbor != parent) {
        result[neighbor] = result[node] - treeSize[neighbor] + n - treeSize[neighbor];
        preOrder(neighbor, node, n);
      }
    }
  }

  public int[] sumOfDistancesInTree(int n, int[][] edges) {
    result = new int[n];
    treeSize = new int[n];
    adjacencyList = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      adjacencyList[i] = new ArrayList<Integer>();
    }

    for (int[] edge: edges) {
      adjacencyList[edge[0]].add(edge[1]);
      adjacencyList[edge[1]].add(edge[0]);
    }

    Arrays.fill(treeSize, 1);

    postOrder(0, -1);
    preOrder(0, -1, n);

    return result;
  }
}
