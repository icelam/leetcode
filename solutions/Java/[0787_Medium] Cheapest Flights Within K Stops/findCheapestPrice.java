class Solution {
  public int findCheapestPrice(int n, int[][] flights, int source, int destination, int k) {
    Map<Integer, List<int[]>> directedEdges = new HashMap<>();
    for (int[] flight: flights) {
      directedEdges.putIfAbsent(flight[0], new ArrayList<>());
      directedEdges.get(flight[0]).add(new int[]{flight[1], flight[2]});
    }

    int[] priceNeeded = new int[n];
    Arrays.fill(priceNeeded, Integer.MAX_VALUE);

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{source, 0});

    int numberOfStops = 0;

    while (!queue.isEmpty() && numberOfStops <= k) {
      int batchSize = queue.size();

      for (int i = 0; i < batchSize; i++) {
        int[] currentFlight = queue.remove();
        int nextStop = currentFlight[0];
        int price = currentFlight[1];

        if (!directedEdges.containsKey(nextStop)) {
          continue;
        }

        for (int[] edge: directedEdges.get(nextStop)) {
          int neighborStop = edge[0];
          int neighborPrice = edge[1];

          if (price + neighborPrice < priceNeeded[neighborStop]) {
            priceNeeded[neighborStop] = price + neighborPrice;
            queue.add(new int[] {neighborStop, priceNeeded[neighborStop]});
          }
        }
      }

      numberOfStops++;
    }

    return priceNeeded[destination] == Integer.MAX_VALUE
      ? -1
      : priceNeeded[destination];
  }
}
