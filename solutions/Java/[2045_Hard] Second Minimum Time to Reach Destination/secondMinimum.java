class Solution {
  private HashMap<Integer, List<Integer>> generateAdjacencyList(int n, int[][] edges) {
    HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      adjacencyList.put(i, new ArrayList<>());
    }

    for (int[] edge: edges) {
      adjacencyList.get(edge[0]).add(edge[1]);
      adjacencyList.get(edge[1]).add(edge[0]);
    }

    return adjacencyList;
  }

  public int secondMinimum(int n, int[][] edges, int time, int change) {
    HashMap<Integer, List<Integer>> adjacencyList = generateAdjacencyList(n, edges);

    // Minimum time to reach node i from node 1
    int[] minDistance = new int[n + 1];
    Arrays.fill(minDistance, Integer.MAX_VALUE);
    minDistance[1] = 0;

    // Second minimum time to reach node 1 from node i
    int[] secondMinDistance = new int[n + 1];
    Arrays.fill(secondMinDistance, Integer.MAX_VALUE);

    int[] frequency = new int[n + 1];
    Arrays.fill(frequency, 0);

    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    heap.add(new int[] {1, 0});

    while (!heap.isEmpty()) {
      int[] currentNodeInformation = heap.remove();
      int node = currentNodeInformation[0];
      int timeUsed = currentNodeInformation[1];

      frequency[node]++;

      // Node N is reached 2 times, it's now the second minimum time used
      if (node == n && frequency[node] == 2) {
        return timeUsed;
      }

      // Handle red light
      if ((timeUsed / change) % 2 == 1) {
        timeUsed = change * (timeUsed / change + 1);
      }

      timeUsed += time;

      for (int neighbor: adjacencyList.get(node)) {
        // No need to visit node that is removed from heap 2 times
        if (frequency[neighbor] == 2) {
          continue;
        }

        // Update min distance if time used is less than stored value.
        // The stored value now becomes second minimum distance.
        if (timeUsed < minDistance[neighbor]) {
          secondMinDistance[neighbor] = minDistance[neighbor];
          minDistance[neighbor] = timeUsed;
          heap.add(new int[] {neighbor, timeUsed});
          continue;
        }

        // Update second minimum distance if time used is less than stored second minumum
        // but larger than minimum distance
        if (timeUsed > minDistance[neighbor] && timeUsed < secondMinDistance[neighbor]) {
          secondMinDistance[neighbor] = timeUsed;
          heap.add(new int[] {neighbor, timeUsed});
        }
      }
    }

    return 0;
  }
}
