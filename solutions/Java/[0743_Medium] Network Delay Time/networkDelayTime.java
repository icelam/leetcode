class Solution {
  private void dijkstra(Map<Integer, List<int[]>> directedEdges, int[] timeNeeded, int source, int n) {
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    priorityQueue.add(new int[]{0, source});

    timeNeeded[source] = 0;

    while (!priorityQueue.isEmpty()) {
      int[] currentInfo = priorityQueue.remove();
      int travelTime = currentInfo[0];
      int target = currentInfo[1];

      if (travelTime > timeNeeded[target] || !directedEdges.containsKey(target)) {
        continue;
      }

      for (int[] edge: directedEdges.get(target)) {
        int neighborTravelTime = edge[0];
        int neighborTarget = edge[1];

        if (timeNeeded[neighborTarget] > travelTime + neighborTravelTime) {
          timeNeeded[neighborTarget] = travelTime + neighborTravelTime;
          priorityQueue.add(new int[]{timeNeeded[neighborTarget], neighborTarget});
        }
      }
    }
  }

  public int networkDelayTime(int[][] times, int n, int k) {
    int result = Integer.MIN_VALUE;
    Map<Integer, List<int[]>> directedEdges = new HashMap<>();
    int[] timeNeeded = new int[n + 1];
    Arrays.fill(timeNeeded, Integer.MAX_VALUE);

    for (int[] time: times) {
      directedEdges.putIfAbsent(time[0], new ArrayList<>());
      directedEdges.get(time[0]).add(new int[]{time[2], time[1]});
    }

    dijkstra(directedEdges, timeNeeded, k, n);

    for (int i = 1; i <= n; i++) {
      result = Math.max(result, timeNeeded[i]);
    }

    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
