class Solution {
  public int minReorder(int n, int[][] connections) {
    Map<Integer, List<int[]>> adjacencyList = new HashMap<>();

    for (int[] c: connections) {
      int a = c[0];
      int b = c[1];
      adjacencyList.putIfAbsent(a, new ArrayList<int[]>());
      adjacencyList.get(a).add(new int[] {b, 1});
      adjacencyList.putIfAbsent(b, new ArrayList<int[]>());
      adjacencyList.get(b).add(new int[] {a, 0});
    }

    int result = 0;
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[n];
    queue.add(0);
    visited[0] = true;

    while (!queue.isEmpty()) {
      int node = queue.remove();

      for (int[] neighbor: adjacencyList.get(node)) {
        int neighborNode = neighbor[0];
        int direction = neighbor[1];
        if (!visited[neighborNode]) {
          result += direction;
          visited[neighborNode] = true;
          queue.add(neighborNode);
        }
      }
    }

    return result;
  }
}
