class Solution {
  public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
    HashMap<Integer, List<List<Integer>>> adjacencyList = new HashMap<>();

    for (int i = 0; i < n; i++) {
      List<List<Integer>> list = new ArrayList<>();
      list.add(new ArrayList<Integer>());
      list.add(new ArrayList<Integer>());
      adjacencyList.put(i, list);
    }

    for (int[] edge: redEdges) {
      adjacencyList.get(edge[0]).get(0).add(edge[1]);
    }

    for (int[] edge: blueEdges) {
      adjacencyList.get(edge[0]).get(1).add(edge[1]);
    }

    int[] result = new int[n];
    Arrays.fill(result, -1);
    result[0] = 0;

    boolean[][] visit = new boolean[n][2];
    visit[0][0] = true;
    visit[0][1] = true;

    Queue<int[]> queue = new LinkedList<>();
    // Node ID, depth, -1 = no color, 0 = red, 1 = blue;
    queue.add(new int[] {0, 0, -1});

    while (!queue.isEmpty()) {
      int[] item = queue.remove();
      int node1 = item[0];
      int steps = item[1];
      int previousColor = item[2];

      for (int currentColor = 0; currentColor < 2; currentColor++) {
        List<Integer> neighbors = adjacencyList.get(node1).get(currentColor);

        for (int node2: adjacencyList.get(node1).get(currentColor)) {
          if (visit[node2][currentColor] || currentColor == previousColor) {
            continue;
          }

          if (result[node2] == -1) {
            result[node2] = 1 + steps;
          }

          visit[node2][currentColor] = true;
          queue.offer(new int[] {node2, steps + 1, currentColor});
        }
      }
    }

    return result;
  }
}
