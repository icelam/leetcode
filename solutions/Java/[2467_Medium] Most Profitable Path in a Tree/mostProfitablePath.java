class Solution {
  private HashMap<Integer, HashSet<Integer>> generateAdjacencyList(int n, int[][] edges) {
    HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();

    for (int i = 0; i < n; i++) {
      adjacencyList.put(i, new HashSet<>());
    }

    for (int[] edge: edges) {
      int node1 = edge[0];
      int node2 = edge[1];
      adjacencyList.get(node1).add(node2);
      adjacencyList.get(node2).add(node1);
    }

    return adjacencyList;
  }

  private int dfs(int n, HashMap<Integer, HashSet<Integer>> adjacencyList, int[] amount, int bob, int source, int parent, int time, int[] distance) {
    int maxIncome = 0;
    int maxChild = Integer.MIN_VALUE;

    if (source == bob) {
      distance[source] = 0;
    } else {
      distance[source] = n;
    }

    for (int neighbor : adjacencyList.get(source)) {
      if (neighbor != parent) {
        maxChild = Math.max(maxChild, dfs(n, adjacencyList, amount, bob, neighbor, source, time + 1, distance));
        distance[source] = Math.min(distance[source], distance[neighbor] + 1);
      }
    }

    if (distance[source] > time) {
      maxIncome += amount[source];
    } else if (distance[source] == time) {
      maxIncome += amount[source] / 2;
    }

    return maxChild == Integer.MIN_VALUE
      ? maxIncome
      : maxIncome + maxChild;
  }

  public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
    int n = amount.length;
    HashMap<Integer, HashSet<Integer>> adjacencyList = generateAdjacencyList(n, edges);
    int[] distance = new int[n];
    return dfs(n, adjacencyList, amount, bob, 0, 0, 0, distance);
  }
}
